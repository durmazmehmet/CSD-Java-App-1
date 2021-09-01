package org.csystem.collectioninjection.configuration;

import org.csystem.collectioninjection.operation.IOperation;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;
import java.util.List;

@Configuration
public class ApplicationRunnerCollectionInjectionConfig {
    private final Collection<IOperation> m_operationCollection;

    public ApplicationRunnerCollectionInjectionConfig(Collection<IOperation> operationCollection)
    {
        m_operationCollection = operationCollection;
    }

    @Bean(name = "collectioninjection")
    public ApplicationRunner runApplication()
    {
        return args ->  {
            System.out.println("ApplicationRunnerCollectionInjectionConfig.runApplication");
            m_operationCollection.forEach(op -> op.apply(10, 20));
        };
    }
}
