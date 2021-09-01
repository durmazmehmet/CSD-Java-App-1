package org.csystem.application.samplecalculator.configuration;

import org.csystem.application.samplecalculator.calculator.SampleCalculator;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CalculatorRunnerConfig {
    private final SampleCalculator m_sampleCalculator;

    public CalculatorRunnerConfig(SampleCalculator sampleCalculator)
    {
        m_sampleCalculator = sampleCalculator;
    }

    @Bean(name = "calculatorrunner")
    public ApplicationRunner runCalculator()
    {
        return args -> {
            System.out.println("CalculatorRunnerConfig.runCalculator");
            m_sampleCalculator.calculate(10, 20, '+');
            m_sampleCalculator.calculate(10, 30, '*');
            m_sampleCalculator.calculate(10, 20, '%');
            m_sampleCalculator.calculate(10, 20, '*');
        };
    }
}
