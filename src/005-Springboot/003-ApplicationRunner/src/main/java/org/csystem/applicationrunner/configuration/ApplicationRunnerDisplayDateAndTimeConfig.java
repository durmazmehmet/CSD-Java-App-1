package org.csystem.applicationrunner.configuration;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalTime;

@Configuration
public class ApplicationRunnerDisplayDateAndTimeConfig {
    @Bean
    public ApplicationRunner runDisplayTime()
    {
        System.out.println("runDisplayTime");
        return args -> {
            LocalTime now = LocalTime.now();

            System.out.printf("Now:%02d:%02d:%02d%n", now.getHour(), now.getMinute(), now.getSecond());
        };
    }

    @Bean
    public ApplicationRunner runDisplayDate()
    {
        System.out.println("runDisplayDate");
        return args -> {
            LocalDate today = LocalDate.now();

            System.out.printf("Today:%02d/%02d/%04d%n", today.getDayOfMonth(), today.getMonthValue(), today.getYear());
        };
    }
}
