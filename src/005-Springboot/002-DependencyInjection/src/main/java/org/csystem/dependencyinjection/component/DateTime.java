package org.csystem.dependencyinjection.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Scope("prototype")
public class DateTime {
    private LocalDate m_localDate;

    @Autowired
    public DateTime(LocalDate localDate)
    {
        System.out.println("DateTime.DateTime");
        m_localDate = localDate;
        m_localDate = m_localDate.plusDays(3);
    }

    public DateTime()
    {
        //...
    }

    public int getYear()
    {
        return m_localDate.getYear();
    }

    public int getMonthValue()
    {
        return m_localDate.getMonthValue();
    }

    public int getDayOfMonth()
    {
        return m_localDate.getDayOfMonth();
    }
}
