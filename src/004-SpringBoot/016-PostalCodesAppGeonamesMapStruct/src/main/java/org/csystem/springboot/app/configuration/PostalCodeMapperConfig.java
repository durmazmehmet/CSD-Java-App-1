package org.csystem.springboot.app.configuration;

import org.csystem.springboot.app.mapper.IPostalCodeMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class PostalCodeMapperConfig {
    @Bean
    public IPostalCodeMapper createMapper()
    {
        return Mappers.getMapper(IPostalCodeMapper.class);
    }
}
