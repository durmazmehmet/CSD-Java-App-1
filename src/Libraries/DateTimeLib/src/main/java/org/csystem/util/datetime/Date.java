package org.csystem.util.datetime;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import static java.util.Calendar.*;

public class Date {
    private final static int [] ms_daysOfMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private final static String[] ms_monthsTR = {"", "Ocak", "Şubat", "Mart", "Nisan", "Mayıs", "Haziran",
            "Temmuz", "Ağustos", "Eylül", "Ekim", "Kasım", "Aralık"};
    private final static String[] ms_dayOfWeeksTR
            = {"Pazar", "Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma", "Cumartesi"};

    private final Calendar m_calendar;

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


    private Date()
    {
        m_calendar = Calendar.getInstance();
    }

    private Date(int day, int mon, int year)
    {
        control(day, mon, year, "Invalid date");

        m_calendar = new GregorianCalendar(year, mon - 1, day);
    }

    public static Date of(int day, int mon, int year)
    {
        return new Date(day, mon, year);
    }

    public static Date of(int day, Month month, int year)
    {
        return of(day, month.ordinal() + 1, year);
    }

    public static Date now()
    {
        return new Date();
    }

    public int getDay() {return m_calendar.get(DAY_OF_MONTH);}
    public int getMonthValue() {return m_calendar.get(MONTH) + 1;}
    public Month getMonth() {return Month.values()[this.getMonthValue() - 1];}
    public int getYear() {return m_calendar.get(YEAR);}
    public String getMonthTR() {return ms_monthsTR[this.getMonthValue()];}
    public int getDayOfWeekValue() {return m_calendar.get(DAY_OF_WEEK) - 1;}
    public DayOfWeek getDayOfWeek() {return DayOfWeek.values()[this.getDayOfWeekValue()];}
    public String getDayOfWeekTR() {return ms_dayOfWeeksTR[this.getDayOfWeekValue()];}
    public int getDayOfYear() {return m_calendar.get(DAY_OF_YEAR);}
    public boolean isLeapYear() {return isLeapYear(this.getYear());}
    public long getTimeInMillis() {return m_calendar.getTimeInMillis();}

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
        return String.format("%02d%c%02d%c%04d",
                this.getDay(), delim, this.getMonthValue(), delim, this.getYear());
    }

    public String toLongDateStringTR(char delim)
    {
        return String.format("%02d %s %04d %s", this.getDay(), ms_monthsTR[getMonthValue()], this.getYear(), getDayOfWeekTR());
    }

    public String toLongDateStringTR()
    {
        return toLongDateStringTR('.');
    }
}
