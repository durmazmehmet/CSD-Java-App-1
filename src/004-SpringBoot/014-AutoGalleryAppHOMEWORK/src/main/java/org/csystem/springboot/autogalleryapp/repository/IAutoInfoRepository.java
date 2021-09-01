package org.csystem.springboot.autogalleryapp.repository;

import org.csystem.springboot.autogalleryapp.entity.AutoInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IAutoInfoRepository extends CrudRepository<AutoInfo, Long> {
    @Query(value = "select * from autos order by make desc limit :limit", nativeQuery = true)
    Iterable<AutoInfo> findTopByMake(int limit);

    @Query(value = "select * from autos order by model_year desc limit :limit", nativeQuery = true)
    Iterable<AutoInfo> findTopByYear(int limit);

    @Query(value = "select * from autos order by model desc limit :limit", nativeQuery = true)
    Iterable<AutoInfo> findTopByModel(int limit);

    @Query(value = "select * from autos order by km desc limit :limit", nativeQuery = true)
    Iterable<AutoInfo> findTopByKm(int limit);

    @Query("from AutoInfo ai where ai.m_make like ?1")
    Iterable<AutoInfo> findByMake(String make);

    @Query("from AutoInfo ai where ai.m_model like ?1")
    Iterable<AutoInfo> findByModel(String model);

    @Query("from AutoInfo ai where ai.m_km between ?1 and ?2")
    Iterable<AutoInfo> findByKmInterval(int min, int max);

    @Query("from AutoInfo ai where ai.m_modelYear between ?1 and ?2")
    Iterable<AutoInfo> findByYearInterval(int min, int max);

    @Query("from AutoInfo ai where ai.m_km between ?1 and ?2 and ai.m_rent=?3")
    Iterable<AutoInfo> findByKmIntervalAndRent(int min, int max, boolean rent);
}
