package org.csystem.springboot.app.component;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class DisplayDateAndTime {
    public DisplayDateAndTime()
    {
        System.out.println("DisplayAndDateTime created");
    }

    @PostConstruct
    public void displayDate()
    {
        System.out.printf("Current Date:%s%n", LocalDate.now());
    }

    @PostConstruct
    public void displayTime()
    {
        System.out.printf("Current Time:%s%n", LocalTime.now());
    }
}
