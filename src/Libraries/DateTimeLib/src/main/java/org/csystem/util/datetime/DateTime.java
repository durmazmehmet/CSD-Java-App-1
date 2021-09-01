package org.csystem.util.datetime;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import static java.util.Calendar.DAY_OF_MONTH;

public class DateTime {
    private final Date m_date;
    private final Time m_time;

    private DateTime(Date date, Time time)
    {
        m_date = date;
        m_time = time;
    }

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

    public DateTime()
    {
        Calendar now = Calendar.getInstance();

        m_date = Date.of(now.get(DAY_OF_MONTH), now.get(Calendar.MONTH) + 1, now.get(Calendar.YEAR));
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
        m_date = Date.of(day, mon, year);
        m_time = new Time(hour, minute, second, millisecond);
    }

    public int getDay() {return m_date.getDay();}

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

    public int getHour()
    {
        return m_time.getHour();
    }

    public int getMinute()
    {
        return m_time.getMinute();
    }

    public int getSecond()
    {
        return m_time.getSecond();
    }

    public int getMillisecond()
    {
        return m_time.getMillisecond();
    }

    public long getTimeInMillis()
    {
        return new GregorianCalendar(getYear(), getMonthValue() - 1, getDay(), getHour(), getMinute(), getSecond()).getTimeInMillis();
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
