package org.csystem.springboot.app.component;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@Component
public class DisplayDateTime {
    public DisplayDateTime()
    {
        System.out.println("DisplayDateTime created");
    }

    @PostConstruct
    public void display()
    {
        System.out.printf("Current DateTime:%s%n", LocalDateTime.now());
    }
}
