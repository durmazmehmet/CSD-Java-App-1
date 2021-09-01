package org.csystem.util.datetime;

import java.util.Calendar;
import java.util.Random;

import static java.util.Calendar.DAY_OF_MONTH;

public class DateTime {
    private Date m_date;
    private Time m_time;

    public static DateTime randomDateTime(Random r, int minYear, int maxYear)
    {
       return new DateTime(Date.randomDate(r, minYear, maxYear), Time.randomTime());
    }

    public static DateTime randomDateTime(int minYear, int maxYear)
    {
        return randomDateTime(new Random(), minYear, maxYear);
    }


    public static DateTime randomLongDateTime(Random r, int minYear, int maxYear)
    {
        return new DateTime(Date.randomDate(r, minYear, maxYear), Time.randomLongTime());
    }

    public static DateTime randomLongDateTime(int minYear, int maxYear)
    {
        return randomLongDateTime(new Random(), minYear, maxYear);
    }

    private DateTime(Date date, Time time)
    {
        m_date = date;
        m_time = time;
    }

    public DateTime()
    {
        Calendar now = Calendar.getInstance();

        m_date = new Date(now.get(DAY_OF_MONTH), now.get(Calendar.MONTH) + 1, now.get(Calendar.YEAR));
        m_time = new Time(now.get(Calendar.HOUR_OF_DAY), now.get(Calendar.MINUTE), now.get(Calendar.SECOND), now.get(Calendar.MILLISECOND));
    }

    public DateTime(int day, int mon, int year)
    {
        this(day, mon, year, 0, 0);
    }

    public DateTime(int day, int mon, int year, int hour, int minute)
    {
        this(day, mon, year, hour, minute, 0);
    }

    public DateTime(int day, Month mon, int year, int hour, int minute)
    {
        this(day, mon.ordinal() + 1, year, hour, minute);
    }

    public DateTime(int day, int mon, int year, int hour, int minute, int second)
    {
        this(day, mon, year, hour, minute, second, 0);
    }

    public DateTime(int day, Month mon, int year, int hour, int minute, int second)
    {
        this(day, mon.ordinal() + 1, year, hour, minute, second);
    }

    public DateTime(int day, Month mon, int year, int hour, int minute, int second, int millisecond)
    {
        this(day, mon.ordinal() + 1, year, hour, minute, second, millisecond);
    }

    public DateTime(int day, int mon, int year, int hour, int minute, int second, int millisecond)
    {
        m_date = new Date(day, mon, year);
        m_time = new Time(hour, minute, second, millisecond);
    }

    public int getDay() {return m_date.getDay();}

    public void setDay(int day)
    {
        m_date.setDay(day);
    }

    public void setMonth(Month month)
    {
        m_date.setMonth(month);
    }

    public void setMonthValue(int mon)
    {
        m_date.setMonthValue(mon);
    }

    public void setYear(int year)
    {
        m_date.setYear(year);
    }

    public int getMonthValue()
    {
        return m_date.getMonthValue();
    }

    public Month getMonth()
    {
        return m_date.getMonth();
    }

    public int getYear()
    {
        return m_date.getYear();
    }

    public String getMonthTR()
    {
        return m_date.getMonthTR();
    }

    public int getDayOfWeekValue()
    {
        return m_date.getDayOfWeekValue();
    }

    public DayOfWeek getDayOfWeek()
    {
        return m_date.getDayOfWeek();
    }

    public String getDayOfWeekTR()
    {
        return m_date.getDayOfWeekTR();
    }

    public int getDayOfYear()
    {
        return m_date.getDayOfYear();
    }

    public boolean isLeapYear()
    {
        return m_date.isLeapYear();
    }

    public void setHour(int hour)
    {
        m_time.setHour(hour);
    }

    public int getHour()
    {
        return m_time.getHour();
    }

    public void setMinute(int minute)
    {
        m_time.setMinute(minute);
    }

    public int getMinute()
    {
        return m_time.getMinute();
    }

    public void setSecond(int second)
    {
        m_time.setSecond(second);
    }

    public int getSecond()
    {
        return m_time.getSecond();
    }

    public void setMillisecond(int millisecond)
    {
        m_time.setMillisecond(millisecond);
    }

    public int getMillisecond()
    {
        return m_time.getMillisecond();
    }

    public String toString()
    {
        return toString('.');
    }

    public String toString(char delim)
    {
        return String.format("%s %s", m_date.toString(delim), m_time.toString());
    }
}
