package org.csystem.applicationrunner.configuration;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;
import java.util.stream.IntStream;

@Configuration
public class ApplicationRunnerRandomNumberGeneratorConfig {
    @Bean
    public ApplicationRunner runRandomGenerator()
    {
        Random r = new Random();

        System.out.println("runRandomGenerator");
        return args -> IntStream.generate(() -> r.nextInt(100)).limit(10).forEach(System.out::println);
    }
}
