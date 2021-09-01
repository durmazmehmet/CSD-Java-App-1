package org.csystem.collectioninjection.configuration;

import org.csystem.collectioninjection.operation.IOperation;
import org.csystem.collectioninjection.operation.IntModulusOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;

@Configuration
public class OperationConfig {
    @Bean
    @Order(5)
    @Primary
    public IOperation getOperation()
    {
        return new IntModulusOperation();
    }
}
