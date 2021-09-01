package org.csystem.collectioninjection.configuration;

import org.csystem.collectioninjection.operation.IOperation;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanPrimaryQualifierConfig {
    private final IOperation m_operation;

    public BeanPrimaryQualifierConfig(IOperation operation)
    {
        m_operation = operation;
    }

    @Bean(name = "beanprimaryqualifier")
    public ApplicationRunner runApplication()
    {
        return args -> {
            System.out.println("BeanPrimaryQualifierConfig.runBeanQualifier");
            m_operation.apply(10, 20);
        };
    }
}
