package org.csystem.app.bean;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalTime;

@Component
public class TimeDisplayer {
    public TimeDisplayer()
    {
        System.out.println("TimeDisplayer.TimeDisplayer");
    }

    @PostConstruct
    public void displayDate()
    {
        LocalTime now = LocalTime.now();

        System.out.printf("%02d:%02d:%04d%n",
                now.getHour(), now.getMinute(), now.getSecond());
    }
}
