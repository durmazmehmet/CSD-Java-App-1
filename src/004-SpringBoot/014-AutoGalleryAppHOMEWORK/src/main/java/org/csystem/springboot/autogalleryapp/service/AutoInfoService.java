package org.csystem.springboot.autogalleryapp.service;

import org.csystem.springboot.autogalleryapp.configuration.CategoryInfo;
import org.csystem.springboot.autogalleryapp.entity.AutoInfo;
import org.csystem.springboot.autogalleryapp.repository.IAutoInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoInfoService implements IAutoInfoService {
    @Autowired
    private IAutoInfoRepository m_autoInfoRepository;

    @Autowired
    private List<CategoryInfo> m_categoryInfos;

    @Override
    public Iterable<AutoInfo> findTopByCategory(int limit, String category)
    {
        int index = m_categoryInfos.indexOf(new CategoryInfo(category));

        if (index >= 0)
            return m_categoryInfos.get(index).getCategory().findProc(limit);

        return m_autoInfoRepository.findTopByMake(limit);
    }

    @Override
    public Iterable<AutoInfo> findByMake(String make)
    {
        return m_autoInfoRepository.findByMake(make);
    }

    @Override
    public Iterable<AutoInfo> findByModel(String model)
    {
        return m_autoInfoRepository.findByModel(model);
    }

    @Override
    public Iterable<AutoInfo> findByKmInterval(int min, int max)
    {
        return m_autoInfoRepository.findByKmInterval(min, max);
    }

    @Override
    public Iterable<AutoInfo> findByYearInterval(int min, int max)
    {
        return m_autoInfoRepository.findByYearInterval(min, max);
    }

    @Override
    public Iterable<AutoInfo> findByKmIntervalAndRent(int min, int max, boolean rent)
    {
        return m_autoInfoRepository.findByKmIntervalAndRent(min, max, rent);
    }

    @Override
    public AutoInfo save(AutoInfo autoInfo)
    {
        return m_autoInfoRepository.save(autoInfo);
    }
}
