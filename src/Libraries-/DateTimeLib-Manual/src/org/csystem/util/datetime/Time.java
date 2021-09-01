package org.csystem.util.datetime;

import java.util.Calendar;
import java.util.Random;

import static java.util.Calendar.*;

public class Time {
    private int m_hour, m_minute, m_second, m_millisecond;

    private static boolean isValidData(int data, int min, int max) //[min, max]
    {
        return min <= data && data <= max;
    }

    private static boolean isValidHour(int hour)
    {
        return isValidData(hour, 0, 23);
    }

    private static boolean isValidMinute(int minute)
    {
        return isValidData(minute, 0, 59);
    }

    private static boolean isValidSecond(int second)
    {
        return isValidData(second, 0, 59);
    }

    private static boolean isValidMillisecond(int millisecond)
    {
        return isValidData(millisecond, 0, 999);
    }

    private static boolean isValidTime(int hour, int minute, int second, int millisecond)
    {
        return isValidHour(hour) && isValidMinute(minute)
                && isValidSecond(second) && isValidMillisecond(millisecond);
    }

    private void doWorkForException(String msg)
    {
        throw new DateTimeException(msg);
    }

    public static Time randomTime(Random r)
    {
        return new Time(r.nextInt(24), r.nextInt(60), r.nextInt(60));
    }

    public static Time randomTime()
    {
        return randomTime(new Random());
    }

    public static Time randomLongTime(Random r)
    {
        return new Time(r.nextInt(24), r.nextInt(60), r.nextInt(60), r.nextInt(1000));
    }

    public static Time randomLongTime()
    {
        return randomLongTime(new Random());
    }

    public Time() // Çalıştığı sistemdeki o an elde edilen zaman
    {
        Calendar now = Calendar.getInstance();

        m_hour = now.get(HOUR_OF_DAY);
        m_minute = now.get(MINUTE);
        m_second = now.get(SECOND);
        m_millisecond = now.get(MILLISECOND);
    }

    public Time(int hour, int minute) //Daha iyi yazılacak
    {
        this(hour, minute, 0);
    }

    public Time(int hour, int minute, int second) //Daha iyi yazılacak
    {
        this(hour, minute, second, 0);
    }

    public Time(int hour, int minute, int second, int millisecond)
    {
        if (!isValidTime(hour, minute, second, millisecond))
            doWorkForException("Invalid Time");

        m_hour = hour;
        m_minute = minute;
        m_second = second;
        m_millisecond = millisecond;
    }

    public void setHour(int hour)
    {
        if (hour == m_hour)
            return;

        if (!isValidHour(hour))
            doWorkForException("Invalid Hour");

        m_hour = hour;
    }

    public int getHour() {return m_hour;}

    public void setMinute(int minute)
    {
        if (minute == m_minute)
            return;

        if (!isValidMinute(minute))
            doWorkForException("Invalid Minute");

        m_minute = minute;
    }

    public int getMinute() {return m_minute;}

    public void setSecond(int second)
    {
        if (second == m_second)
            return;

        if (!isValidSecond(second))
            doWorkForException("Invalid Second");

        m_second = second;
    }

    public int getSecond() {return m_second;}

    public void setMillisecond(int millisecond)
    {
        if (millisecond == m_millisecond)
            return;

        if (!isValidMillisecond(millisecond))
            doWorkForException("Invalid Millisecond");

        m_millisecond = millisecond;
    }

    public int getMillisecond() {return m_millisecond;}



    public String toShortTimeString()
    {
        return String.format("%02d:%02d", m_hour, m_minute);
    }

    public String toString()
    {
        return String.format("%02d:%02d:%02d",
            m_hour, m_minute, m_second);
    }

    public String toLongTimeString()
    {
        return String.format("%02d:%02d:%02d.%03d",
                m_hour, m_minute, m_second, m_millisecond);
    }
}
