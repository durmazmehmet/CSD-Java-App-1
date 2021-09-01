package org.csystem.deviceapp.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.csystem.deviceapp.entity.DeviceInfo;
import org.csystem.repository.RepositoryException;
 
public enum DeviceRepository implements IDeviceRepository {
	INSTANCE;
	private static final String URL = "jdbc:postgresql://localhost:5432/devicesappdb";
	private static final String USERNAME = "postgres";
	private static final String PASSWORD = "csd1993";	
	
	//SQL Commands
	private static final String FIND_WITH_PORTS_LIMIT_CMD = 
			"select d.device_id, d.name,  d.ip_address, " + 
			"string_agg(cast(p.num as varchar), ',') as \"ports\"\n" + 
			"from devices d inner join ports p on p.device_id=d.device_id\n" + 
			"group by d.device_id order by d.device_id desc limit ?;";
	
	private static final String FIND_ALL_CMD = "select * from devices order by name";
	
	private static final String FIND_BY_ID_CMD = "select * from devices where device_id=?";
	
	private static final String FIND_BY_NAME_CMD = "select * from devices where name=?";
	
	private static final String FIND_BY_NAME_CONTAINS_CMD = "select * from devices where name like ?";
	
	private static final String FIND_PORTS_BY_NAME_CONTAINS_CMD = 
			"select d.device_id, d.name, d.ip_address, string_agg(cast(p.num as varchar), ',') " + 
			"from devices d inner join ports p on p.device_id=d.device_id " + 
			"where d.name like ? group by d.device_id";
	
	private static final String SAVE_DEVICE_CMD = 
			"insert into devices (name, ip_address) values (?, ?)";
	
	private static final String SAVE_PORT_CMD = 
			"insert into ports (device_id, num) values (?, ?)";
	
	
	private static int getGeneratedId(PreparedStatement stmt) throws SQLException
	{
		ResultSet rs = stmt.getGeneratedKeys();
		
		rs.next();
		
		return rs.getInt(1);		
	}
	
	private <S extends DeviceInfo> S saveProc(Connection con, S d) throws SQLException
	{		
		try (PreparedStatement stmt = con.prepareStatement(SAVE_DEVICE_CMD, Statement.RETURN_GENERATED_KEYS)) {
			con.setAutoCommit(false);
			stmt.setString(1, d.getName());
			stmt.setString(2, d.getIpAddress());
			
			int count = stmt.executeUpdate();
			
			if (count != 0) { // Dikkat insert için gerek olmasa da gösterdik 
				d.setId(getGeneratedId(stmt));											
				con.commit();
			}
			else 
				con.rollback();
			
			return d;
		}	
		catch (Throwable ex) {
			con.rollback();
			throw ex;
		}
	}
	
	
	private <S extends DeviceInfo> S saveProc(Connection con, S d, int...ports) throws SQLException
	{		
		try (PreparedStatement stmtDevices = con.prepareStatement(SAVE_DEVICE_CMD, Statement.RETURN_GENERATED_KEYS);
				PreparedStatement stmtPorts = con.prepareStatement(SAVE_PORT_CMD)) {
			con.setAutoCommit(false);
			stmtDevices.setString(1, d.getName());
			stmtDevices.setString(2, d.getIpAddress());
			
			int count = stmtDevices.executeUpdate();
			
			if (count != 0) {				
				d.setId(getGeneratedId(stmtDevices));
				stmtPorts.setInt(1, d.getId());
				
				for (int port : ports) {
					d.add(port);
					stmtPorts.setInt(2, port);
					stmtPorts.executeUpdate();
				}
				
				con.commit();
			}
			else 
				con.rollback();
			
			return d;
		}	
		catch (Throwable ex) {
			con.rollback();
			throw ex;
		}
	}
	
	private DeviceInfo getDevice(ResultSet rs) throws SQLException
	{
		return new DeviceInfo(rs.getInt(1), rs.getString(2), rs.getString(3));
	}
	
	@Override
	public <S extends DeviceInfo> S save(S d)
	{		
		try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {			 
			return saveProc(con, d);
		}
		catch (Throwable ex) {
			throw new RepositoryException("exception in save", ex);
		}
	}
	@Override
	public <S extends DeviceInfo> S save(S d, int...ports)
	{
		try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			return saveProc(con, d, ports);
		}
		catch (Throwable ex) {
			throw new RepositoryException("exception in save with ports", ex);
		}				
	}

	@Override
	public Iterable<? extends DeviceInfo> findAll() //lazy loading
	{		
		
		List<DeviceInfo> devices = new ArrayList<>();
		
		try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				Statement stmt = con.createStatement()) {
			
			ResultSet rs = stmt.executeQuery(FIND_ALL_CMD);
			
			while (rs.next())
				devices.add(getDevice(rs));					
			
			return devices;
		}	
		catch (Throwable ex) {
			throw new RepositoryException("exception in findAll", ex);
		}						
	}
	
	@Override
	public Iterable<DeviceInfo> findAll(int limit)
	{		
		List<DeviceInfo> devices = new ArrayList<>();
		
		try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement stmt = con.prepareStatement(FIND_WITH_PORTS_LIMIT_CMD)) {
			stmt.setInt(1, limit);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				DeviceInfo di = new DeviceInfo(rs.getInt(1), rs.getString(2), rs.getString(3));
				
				devices.add(di);
				
				String [] portsStr = rs.getString(4).split("[,]+");				
				
				for (String ps : portsStr)
					di.add(Integer.parseInt(ps));				
			}
			
			return devices;
		}
		catch (Throwable ex) {
			throw new RepositoryException("findPortsByNameContains", ex);
		}					
	}

	@Override
	public Optional<DeviceInfo> findById(Integer id)
	{		
		try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD); 
				PreparedStatement stmt = con.prepareStatement(FIND_BY_ID_CMD)) {
			stmt.setInt(1, id);		
			
			ResultSet rs = stmt.executeQuery();
			
			return rs.next() ? Optional.of(getDevice(rs)) : Optional.empty();
		}	
		catch (Throwable ex) {
			throw new RepositoryException("exception in findById", ex);
		}			
	}
	
	@Override
	public Iterable<DeviceInfo> findByName(String name)
	{
		List<DeviceInfo> devices = new ArrayList<>();
		
		try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD); 
				PreparedStatement stmt = con.prepareStatement(FIND_BY_NAME_CMD)) {
			stmt.setString(1, name);		
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next())
				devices.add(getDevice(rs));
			
			return devices;
		}	
		catch (Throwable ex) {
			throw new RepositoryException("exception in findByName", ex);
		}			
	}
	
	@Override
	public Iterable<DeviceInfo> findByNameContains(String name)
	{
		List<DeviceInfo> devices = new ArrayList<>();
		
		try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD); 
				PreparedStatement stmt = con.prepareStatement(FIND_BY_NAME_CONTAINS_CMD)) {
			stmt.setString(1, "%" + name + "%");		
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next())
				devices.add(getDevice(rs));
			
			return devices;
		}	
		catch (Throwable ex) {
			throw new RepositoryException("exception in findByNameContains", ex);
		}			
	}

	@Override
	public Iterable<DeviceInfo> findPortsByNameContains(String name)
	{		
		List<DeviceInfo> devices = new ArrayList<>();
		
		try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement stmt = con.prepareStatement(FIND_PORTS_BY_NAME_CONTAINS_CMD)) {
			stmt.setString(1, "%" + name + "%");
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				DeviceInfo di = new DeviceInfo(rs.getInt(1), rs.getString(2), rs.getString(3));
				
				devices.add(di);
				
				String [] portsStr = rs.getString(4).split("[,]+");				
				
				for (String ps : portsStr)
					di.add(Integer.parseInt(ps));				
			}
			
			return devices;
		}
		catch (Throwable ex) {
			throw new RepositoryException("findPortsByNameContains", ex);
		}
	}
	
	@Override
	public void delete(DeviceInfo entity)
	{
		throw new UnsupportedOperationException("delete not supported for device");
	}

	@Override
	public boolean existsById(Integer id)
	{
		throw new UnsupportedOperationException("existById not supported for device");
	}

	@Override
	public long count()
	{
		// TODO Auto-generated method stub
		return 0;
	}
	
			
}









