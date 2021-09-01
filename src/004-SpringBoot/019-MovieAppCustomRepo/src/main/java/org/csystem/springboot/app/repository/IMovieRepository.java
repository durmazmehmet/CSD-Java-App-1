package org.csystem.springboot.app.repository;

import org.csystem.springboot.app.entity.MovieInfo;

public interface IMovieRepository extends ICrudRepository<MovieInfo, Long> {
    Iterable<MovieInfo> findByYear(int year);
    Iterable<MovieInfo> findByYears(int start, int end);
    Iterable<MovieInfo> findByNameStartsWith(String name);
    Iterable<MovieInfo> findByNameContaining(String name);
}
