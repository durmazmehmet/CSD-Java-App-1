package org.csystem.springboot.app.service;

import org.csystem.springboot.app.viewmodel.MovieInfoViewModel;

import java.util.Collection;
import java.util.Optional;

public interface IMovieService {
    MovieInfoViewModel save(MovieInfoViewModel movieInfoViewModel);
    Collection<MovieInfoViewModel> getMovies();
    Optional<MovieInfoViewModel> getById(long id);
}
