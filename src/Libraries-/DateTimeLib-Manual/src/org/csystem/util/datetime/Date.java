package org.csystem.util.datetime;

import java.util.Calendar;
import java.util.Random;

import static java.util.Calendar.*;

public class Date {
    private final static int [] ms_daysOfMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private final static String[] ms_monthsTR = {"", "Ocak", "Şubat", "Mart", "Nisan", "Mayıs", "Haziran",
            "Temmuz", "Ağustos", "Eylül", "Ekim", "Kasım", "Aralık"};
    private final static String[] ms_dayOfWeeksTR
            = {"Pazar", "Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma", "Cumartesi"};

    private int m_day, m_mon, m_year;

    private static int getDayOfWeek(int day, int mon, int year)
    {
        int totalDays = getDayOfYear(day, mon, year);

        if (year >= 1900) {
            for (int y = 1900; y < year; ++y)
                totalDays += isLeapYear(y) ? 366 : 365;
        }
        else {
            //TODO:
        }


        return totalDays % 7;
    }

    private static int getDayOfYear(int day, int mon, int year)
    {
        int dayOfYear = day;

        for (int m = mon - 1; m >= 1; --m)
            dayOfYear += ms_daysOfMonth[m];

        if (isLeapYear(year) && mon > 2)
            ++dayOfYear;

        return dayOfYear;
    }

    private static boolean isValidDate(int day, int mon, int year)
    {
        if (day < 1 || day > 31 || mon < 1 || mon > 12)
            return false;

        int days = isLeapYear(year) && mon == 2 ? 29 : ms_daysOfMonth[mon];

        return day <= days;
    }


    private static boolean isLeapYear(int year)
    {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    private static void control(int day, int mon, int year, String msg)
    {
        if (!isValidDate(day, mon, year))
            throw new DateTimeException(msg);    }


    public Date()
    {
        Calendar now = Calendar.getInstance();

        m_day = now.get(DAY_OF_MONTH);
        m_mon = now.get(MONTH) + 1;
        m_year = now.get(YEAR);
    }

    public Date(int day, Month month, int year)
    {
        this(day, month.ordinal() + 1, year);
    }

    public Date(int day, int mon, int year)
    {
        control(day, mon, year, "Invalid date");
        m_day = day;
        m_mon = mon;
        m_year = year;
    }

    public void setDay(int day)
    {
        if (day == m_day)
            return;

        control(day, m_mon, m_year, "Invalid day");
        m_day = day;
    }

    public void setMonth(Month month)
    {
        setMonthValue(month.ordinal() + 1);
    }

    public void setMonthValue(int mon)
    {
        if (mon == m_mon)
            return;

        control(m_day, mon, m_year, "Invalid month value");
        m_mon = mon;
    }

    public void setYear(int year)
    {
        if (year == m_year)
            return;

        control(m_day, m_mon, year, "Invalid year");
        m_year = year;
    }

    public int getDay() {return m_day;}
    public int getMonthValue() {return m_mon;}
    public Month getMonth() {return Month.values()[m_mon - 1];}
    public int getYear() {return m_year;}
    public String getMonthTR() {return ms_monthsTR[m_mon];}
    public int getDayOfWeekValue() {return getDayOfWeek(m_day, m_mon, m_year);}
    public DayOfWeek getDayOfWeek() {return DayOfWeek.values()[getDayOfWeekValue()];}
    public String getDayOfWeekTR() {return ms_dayOfWeeksTR[getDayOfWeekValue()];}
    public int getDayOfYear() {return getDayOfYear(m_day, m_mon, m_year);}
    public boolean isLeapYear() {return isLeapYear(m_year);}

    public static Date makeDate(int day, int mon, int year)
    {
        Date date = null;

        try {
            date = new Date(day, mon, year);
        }
        catch (DateTimeException ex) {

        }

        return date;
    }

    public static Date randomDate(Random r, int minYear, int maxYear) //[minYear, maxYear]
    {
        int year = r.nextInt(maxYear + 1 - minYear) + minYear;
        int mon = r.nextInt(12) + 1;
        int daysOfMonth = mon == 2 && isLeapYear(year) ? 29 : ms_daysOfMonth[mon];
        int day = r.nextInt(daysOfMonth) + 1;

        return new Date(day, mon, year);
    }

    public static Date randomDate(int minYear, int maxYear)
    {
        return randomDate(new Random(), minYear, maxYear);
    }

    public static Date randomDate(Random r)
    {
        return randomDate(r, 1900, 2100);
    }

    public static Date randomDate()
    {
        return randomDate(new Random());
    }

    public String toString() {return toString('.');}
    public String toString(char delim)
    {
        return String.format("%02d%c%02d%c%04d", m_day, delim, m_mon, delim, m_year);
    }

    public String toLongDateStringTR(char delim)
    {
        return String.format("%02d %s %04d %s", m_day, ms_monthsTR[m_mon], m_year, getDayOfWeekTR());
    }

    public String toLongDateStringTR()
    {
        return toLongDateStringTR('.');
    }
}
