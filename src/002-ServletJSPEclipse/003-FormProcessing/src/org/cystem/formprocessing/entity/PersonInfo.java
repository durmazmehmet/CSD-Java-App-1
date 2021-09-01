package org.cystem.formprocessing.entity;

public class PersonInfo {
	private String m_name;
	private String m_citizenId;
	private int m_age;	
	
	public PersonInfo(String name, String citizenId, int age) 
	{	
		m_name = name;
		m_citizenId = citizenId;
		m_age = age;
	}
	
	public String getName()
	{
		return m_name;
	}
	
	public void setName(String name)
	{
		m_name = name;
	}
	
	public String getCitizenId() 
	{
		return m_citizenId;
	}
	
	public void setCitizenId(String citizenId) 
	{
		m_citizenId = citizenId;
	}
	public int getAge() 
	{
		return m_age;
	}
	
	public void setAge(int age) 
	{
		m_age = age;
	}
	
	@Override
	public String toString()
	{		
		return String.format("%s:%s:%d", m_name, m_citizenId, m_age);
	}
}
		
