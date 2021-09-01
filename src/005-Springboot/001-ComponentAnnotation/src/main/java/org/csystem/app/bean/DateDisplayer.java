package org.csystem.app.bean;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@Component
public class DateDisplayer {
    public DateDisplayer()
    {
        System.out.println("DateDisplayer.DateDisplayer");
    }

    @PostConstruct
    public void displayDate()
    {
        LocalDate today = LocalDate.now();

        System.out.printf("%02d/%02d/%04d%n",
                today.getDayOfMonth(), today.getMonthValue(), today.getYear());
    }
}
