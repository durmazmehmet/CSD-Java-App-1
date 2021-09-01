package org.csystem.deviceapp.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

import org.csystem.deviceapp.entity.DeviceInfo;
import org.csystem.repository.RepositoryException;

public enum DeviceRepository implements IDeviceRepository { //Aynı anda erişim dikkate alınmamıştır
	INSTANCE;	
	private static final HashMap<Integer, DeviceInfo> ms_devices;
	private static int m_curIndex = 4;
	
	static {
		ms_devices = new HashMap<>();		
		ms_devices.put(1, new DeviceInfo(1, "test", "192.168.2.34"));
		ms_devices.put(2, new DeviceInfo(2, "mest", "192.168.1.34"));
		ms_devices.put(3, new DeviceInfo(3, "jest", "192.168.2.56"));
	}

	@Override
	public <S extends DeviceInfo> S save(S d)
	{
		try {
			d.setId(m_curIndex++);
			ms_devices.put(d.getId(), d);
			
			return d;
		}	
		catch (Throwable ex) {
			throw new RepositoryException("exception in save", ex);
		}		
	}

	@Override
	public Iterable<? extends DeviceInfo> findAll()
	{
		try {
			return new ArrayList<DeviceInfo>(ms_devices.values());
		}	
		catch (Throwable ex) {
			throw new RepositoryException("exception in findAll", ex);
		}						
	}

	@Override
	public Optional<DeviceInfo> findById(Integer id)
	{
		try {
			return Optional.ofNullable(ms_devices.get(id));
//			return ms_devices.containsKey(id) ? Optional.of(ms_devices.get(id)) : Optional.empty();			
		}	
		catch (Throwable ex) {
			throw new RepositoryException("exception in findById", ex);
		}			
	}
	
	@Override
	public Iterable<DeviceInfo> findByName(String name)
	{
		ArrayList<DeviceInfo> devices = new ArrayList<>();
		
		try {
			for (DeviceInfo di : ms_devices.values()) {
				if (di.getName().equals(name))
					devices.add(di);				
			}
			
			return devices;
		}
		catch (Throwable ex) {
			throw new RepositoryException("exception in findByName", ex);
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









