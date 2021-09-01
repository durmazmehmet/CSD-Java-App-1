package org.csystem.springboot.app.model;

import javax.persistence.*;

@Entity
@Table(name = "devices")
public class DeviceInfo { //POJO
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "device_id")
    private long m_id;

    @Column(name="name")
    private String name;

    @Column(name="ip_address")
    private String ipAddress;


    public DeviceInfo()
    {}
    public DeviceInfo(String name, String ipAddress)
    {
        this.name = name;
        this.ipAddress = ipAddress;
    }

    public long getId()
    {
        return m_id;
    }

    public void setId(long id)
    {
        m_id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getIpAddress()
    {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress)
    {
        this.ipAddress = ipAddress;
    }
    //...
}
