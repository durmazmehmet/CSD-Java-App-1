package org.csystem.applicationrunner.applicationrunner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
@Order(2)
public class TimeApplicationRunner implements ApplicationRunner {
    private final LocalTime m_localTime;

    public TimeApplicationRunner(LocalTime localTime)
    {
        m_localTime = localTime.plusHours(3);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        System.out.printf("Now:%02d:%02d:%02d%n", m_localTime.getHour(), m_localTime.getMinute(), m_localTime.getSecond());
    }
}
