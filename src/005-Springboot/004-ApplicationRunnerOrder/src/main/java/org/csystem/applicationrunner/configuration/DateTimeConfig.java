package org.csystem.applicationrunner.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalDate;
import java.time.LocalTime;

@Configuration
public class DateTimeConfig {
    @Bean
    @Scope("prototype")
    public LocalDate getLocalDate()
    {
        return LocalDate.now();
    }

    @Bean
    @Scope("prototype")
    public LocalTime getLocalTime()
    {
        return LocalTime.now();
    }
}
