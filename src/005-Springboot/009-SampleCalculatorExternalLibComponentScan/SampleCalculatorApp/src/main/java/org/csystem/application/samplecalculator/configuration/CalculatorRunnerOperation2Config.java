package org.csystem.application.samplecalculator.configuration;

import org.csystem.application.samplecalculator.calculator.SampleCalculator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CalculatorRunnerOperation2Config {
    @Value("${op2.message}")
    private String m_message;
    private final SampleCalculator m_sampleCalculator;

    public CalculatorRunnerOperation2Config(SampleCalculator sampleCalculator)
    {
        m_sampleCalculator = sampleCalculator;
    }

    @Bean(name = "calculatorrunneroperation2")
    public ApplicationRunner runCalculator(@Value("${op2.a:0}") int a, @Value("${op2.b:0}") int b, @Value("${op2.op:*}") char op)
    {
        return args -> {
            System.out.println(m_message);
            m_sampleCalculator.calculate(a, b, op);
        };
    }
}
