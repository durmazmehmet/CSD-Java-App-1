package org.csystem.springboot.app.cameraapp;


import org.csystem.util.datetime.DateTime;

public class CarCameraInfo {
    private String m_plate;
    private DateTime m_date;
    private String m_place;

    public CarCameraInfo(String plate, DateTime date, String place)
    {
        m_plate = plate;
        m_date = date;
        m_place = place;
    }

    public String getPlate()
    {
        return m_plate;
    }

    public void setPlate(String plate)
    {
        m_plate = plate;
    }

    public DateTime getDate()
    {
        return m_date;
    }

    public void setDate(DateTime date)
    {
        m_date = date;
    }

    public String getPlace()
    {
        return m_place;
    }

    public void setPlace(String place)
    {
        m_place = place;
    }

    public String toString()
    {
        return String.format("[%s]%s:%s", m_plate, m_place, m_date.toString());
    }
}
