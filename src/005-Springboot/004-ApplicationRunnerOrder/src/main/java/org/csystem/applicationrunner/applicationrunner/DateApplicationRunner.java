package org.csystem.applicationrunner.applicationrunner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Order(3)
public class DateApplicationRunner implements ApplicationRunner {
    private final LocalDate m_localDate;

    public DateApplicationRunner(LocalDate localDate)
    {
        m_localDate = localDate;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        System.out.printf("Today:%02d/%02d/%04d%n", m_localDate.getDayOfMonth(), m_localDate.getMonthValue(), m_localDate.getYear());
    }
}
