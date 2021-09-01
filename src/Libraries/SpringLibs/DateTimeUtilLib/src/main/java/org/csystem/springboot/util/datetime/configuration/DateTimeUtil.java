package org.csystem.springboot.util.datetime.configuration;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public final class DateTimeUtil {
    private DateTimeUtil() {}

    public static long toMilliseconds(LocalDateTime localDateTime)
    {
        return toMilliseconds(localDateTime, ZoneId.systemDefault());
    }

    public static long toMilliseconds(LocalDateTime localDateTime, ZoneId zoneId)
    {
        return localDateTime.atZone(zoneId).toInstant().toEpochMilli();
    }

    public static LocalDateTime toLocalDateTime(long milliseconds)
    {
        return toLocalDateTime(milliseconds, ZoneId.systemDefault());
    }

    public static LocalDateTime toLocalDateTime(long milliseconds, ZoneId zoneId)
    {
        return Instant.ofEpochMilli(milliseconds).atZone(zoneId).toLocalDateTime();
    }

    public static long toMilliseconds(LocalDate localDate)
    {
        return toMilliseconds(localDate, ZoneId.systemDefault());
    }

    public static long toMilliseconds(LocalDate localDate, ZoneId zoneId)
    {
        return localDate.atStartOfDay(zoneId).toInstant().toEpochMilli();
    }

    public static LocalDate toLocalDate(long milliseconds)
    {
        return toLocalDate(milliseconds, ZoneId.systemDefault());
    }

    public static LocalDate toLocalDate(long milliseconds, ZoneId zoneId)
    {
        return Instant.ofEpochMilli(milliseconds).atZone(zoneId).toLocalDate();
    }
}
