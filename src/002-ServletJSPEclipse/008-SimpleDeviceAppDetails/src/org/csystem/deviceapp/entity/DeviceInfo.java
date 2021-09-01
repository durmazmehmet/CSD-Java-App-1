package org.csystem.deviceapp.entity;

import java.util.ArrayList;
import java.util.List;

public class DeviceInfo {
	private int m_id;
	private String m_name;
	private String m_ipAddress;
	private List<Integer> m_ports;
	
	public DeviceInfo(String name, String ipAddress)
	{		
		this(0, name, ipAddress);
	}
	
	public DeviceInfo(int id, String name, String ipAddress)
	{		
		m_id = id;
		m_name = name;
		m_ipAddress = ipAddress;
		
		m_ports = new ArrayList<>();
	}
	
	public int getId() 
	{
		return m_id;
	}
	
	public void setId(int id) 
	{
		m_id = id;
	}
	
	public String getName() 
	{
		return m_name;
	}
	
	public void setName(String name) 
	{
		m_name = name;
	}
	
	public String getIpAddress() 
	{
		return m_ipAddress;
	}
	
	public void setIpAddress(String ipAddress) 
	{		
		m_ipAddress = ipAddress;
	}	
	
	public boolean add(Integer e)
	{
		return m_ports.add(e);
	}

	public Integer getPortByIndex(int index)
	{
		return m_ports.get(index);
	}
	
	public int getNumberOfPorts() {return m_ports.size();}

	public String toString()
	{
		return String.format("[%d]%s:%s", m_id, m_name, m_ipAddress);
	}	
}
