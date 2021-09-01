package org.csystem.springboot.app.configuration;

import org.csystem.springboot.app.calculator.SimpleCalculator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SimpleCalculatorConfig {
    @Bean
    public ApplicationRunner runCalculator(SimpleCalculator calculator,
                                           @Value("${a:1}") int a,
                                           @Value("${b:1}") int b,
                                           @Value("${op:+}") char op)
    {

        return args -> {
            System.out.printf("%d %c %d = %d%n", a, op, b, calculator.calculate(a, b, op));
        };
    }
}
