package org.csystem.collectioninjection.configuration;

import org.csystem.collectioninjection.operation.IOperation;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanQualifierConfig {
    private final IOperation m_operation;

    public BeanQualifierConfig(@Qualifier("intAddOperation") IOperation operation)
    {
        m_operation = operation;
    }

    @Bean(name = "beanqualifier")
    public ApplicationRunner runApplication()
    {
        return args -> {
            System.out.println("BeanQualifierConfig.runBeanQualifier");
            m_operation.apply(10, 20);
        };
    }
}
