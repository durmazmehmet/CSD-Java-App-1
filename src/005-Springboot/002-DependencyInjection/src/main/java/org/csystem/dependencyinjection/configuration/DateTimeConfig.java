package org.csystem.dependencyinjection.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalDate;

@Configuration
public class DateTimeConfig {
    @Bean(name = "localdate")
    @Scope("prototype")
    public LocalDate getLocalDate()
    {
        System.out.println("getLocalDate");

        return LocalDate.now();
    }
}
