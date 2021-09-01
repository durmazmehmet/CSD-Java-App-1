package org.csystem.springboot.autogalleryapp.configuration;

import org.csystem.springboot.autogalleryapp.repository.IAutoInfoRepository;
import org.csystem.springboot.autogalleryapp.service.AutoInfoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;


@Configuration
public class AutoServiceConfig {
    private final IAutoInfoRepository m_autoInfoRepository;

    public AutoServiceConfig(IAutoInfoRepository autoInfoRepository)
    {
        m_autoInfoRepository  = autoInfoRepository;
    }

    @Bean
    public List<CategoryInfo> getCategories()
    {
        return Arrays.asList(
                new CategoryInfo("km", m_autoInfoRepository::findTopByKm),
                new CategoryInfo("make", m_autoInfoRepository::findTopByMake),
                new CategoryInfo("model", m_autoInfoRepository::findTopByModel),
                new CategoryInfo("year", m_autoInfoRepository::findTopByYear));
    }
}
