package org.csystem.dependencyinjection.component;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DateTimeDisplayConstructorInjection {
    private final DateTime m_dateTime;

    public DateTimeDisplayConstructorInjection(DateTime dateTime) //ctor injection
    {
        m_dateTime = dateTime;
    }

    @PostConstruct
    public void display()
    {
        System.out.println("DateTimeDisplayConstructorInjection:");
        System.out.printf("%02d/%02d/%04d%n",
                m_dateTime.getDayOfMonth(), m_dateTime.getMonthValue(), m_dateTime.getYear());
    }
}
