package org.csystem.application.samplecalculator.configuration;

import org.csystem.application.samplecalculator.calculator.SampleCalculator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CalculatorRunnerOperation1Config {
    @Value("${op1.message}")
    private String m_message;
    private final SampleCalculator m_sampleCalculator;

    public CalculatorRunnerOperation1Config(SampleCalculator sampleCalculator)
    {
        m_sampleCalculator = sampleCalculator;
    }

    @Bean(name = "calculatorrunneroperation1")
    public ApplicationRunner runCalculator(@Value("${op1.a:1}") int a, @Value("${op1.b:1}") int b, @Value("${op1.op:+}") char op)
    {
        return args -> {
            System.out.println(m_message);
            m_sampleCalculator.calculate(a, b, op);
        };
    }
}
