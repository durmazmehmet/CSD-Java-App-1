package org.csystem.samples;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class BirthDateController {
    private LocalDate m_birtdDate;
    public enum Status {BEFORE, AFTER, EQUALS}

    public BirthDateController(int day, int mon, int year)
    {
        m_birtdDate = LocalDate.of(year, mon, day);
    }

    public double getAge()
    {
        return ChronoUnit.DAYS.between(m_birtdDate, LocalDate.now()) / 365.;
    }

    public Status getStatus()
    {
        LocalDate now = LocalDate.now();

        if (m_birtdDate.isAfter(now))
            throw  new DateTimeException("Invalid Birtdate");

        LocalDate birthDay = m_birtdDate.withYear(now.getYear());

        if (now.equals(birthDay))
            return Status.EQUALS;

        if (now.isBefore(birthDay))
            return Status.AFTER;

        return Status.BEFORE;
    }
}
