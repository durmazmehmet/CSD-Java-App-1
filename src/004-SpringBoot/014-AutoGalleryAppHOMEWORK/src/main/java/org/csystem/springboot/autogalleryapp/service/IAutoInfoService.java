package org.csystem.springboot.autogalleryapp.service;

import org.csystem.springboot.autogalleryapp.entity.AutoInfo;

public interface IAutoInfoService {
    Iterable<AutoInfo> findTopByCategory(int limit, String category);
    Iterable<AutoInfo> findByMake(String make);
    Iterable<AutoInfo> findByModel(String model);
    Iterable<AutoInfo> findByKmInterval(int min, int max);
    Iterable<AutoInfo> findByYearInterval(int min, int max);
    Iterable<AutoInfo> findByKmIntervalAndRent(int min, int max, boolean rent);
    AutoInfo save(AutoInfo autoInfo);
}
