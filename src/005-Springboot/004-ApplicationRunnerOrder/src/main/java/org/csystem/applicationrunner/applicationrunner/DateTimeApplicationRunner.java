package org.csystem.applicationrunner.applicationrunner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
@Order(4)
public class DateTimeApplicationRunner implements ApplicationRunner {
    private final LocalDate m_localDate;
    private final LocalTime m_localTime;

    public DateTimeApplicationRunner(LocalDate localDate, LocalTime localTime)
    {
        m_localDate = localDate;
        m_localTime = localTime;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        System.out.printf("DateTime:%s %s%n", m_localDate, m_localTime);
    }
}
