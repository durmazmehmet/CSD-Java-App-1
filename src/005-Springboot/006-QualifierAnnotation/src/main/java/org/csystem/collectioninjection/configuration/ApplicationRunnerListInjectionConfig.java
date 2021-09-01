package org.csystem.collectioninjection.configuration;

import org.csystem.collectioninjection.operation.IOperation;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Configuration
public class ApplicationRunnerListInjectionConfig {
    private final List<IOperation> m_operationCollection;

    public ApplicationRunnerListInjectionConfig(List<IOperation> operationCollection)
    {
        m_operationCollection = operationCollection;
    }

    @Bean(name = "listinjection")
    public ApplicationRunner runApplication()
    {
        return args ->  {
            System.out.println("ApplicationRunnerListInjectionConfig.runApplication");
            m_operationCollection.forEach(op -> op.apply(10, 20));
        };
    }
}
