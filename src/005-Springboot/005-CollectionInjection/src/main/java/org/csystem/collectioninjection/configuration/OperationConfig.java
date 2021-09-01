package org.csystem.collectioninjection.configuration;

import org.csystem.collectioninjection.operation.IOperation;
import org.csystem.collectioninjection.operation.IntModulusOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
public class OperationConfig {
    @Bean
    @Order(5)
    public IOperation getOperation()
    {
        return new IntModulusOperation();
    }
}
