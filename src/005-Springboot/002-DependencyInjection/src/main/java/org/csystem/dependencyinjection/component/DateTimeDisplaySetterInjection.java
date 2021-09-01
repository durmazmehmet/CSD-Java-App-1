package org.csystem.dependencyinjection.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DateTimeDisplaySetterInjection {
    private DateTime m_dateTime;

    @Autowired //setter injection
    public void setDateTime(DateTime dateTime)
    {
        m_dateTime = dateTime;
    }

    @PostConstruct
    public void display()
    {
        System.out.println("DateTimeDisplaySetterInjection:");
        System.out.printf("%02d/%02d/%04d%n",
                m_dateTime.getDayOfMonth(), m_dateTime.getMonthValue(), m_dateTime.getYear());
    }
}
