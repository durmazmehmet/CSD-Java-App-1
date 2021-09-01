package org.csystem.springboot.app.service;

import org.csystem.springboot.app.entity.MovieInfo;
import org.csystem.springboot.app.repository.IMovieRepository;
import org.csystem.springboot.app.viewmodel.MovieInfoViewModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MovieService implements IMovieService {
    private final IMovieRepository m_movieRepository;
    private final Converter<MovieInfo, MovieInfoViewModel> m_movieToMovieModelConverter;
    private final Converter<MovieInfoViewModel, MovieInfo> m_movieModelToMovieConverter;

    public MovieService(IMovieRepository movieRepository, Converter<MovieInfo, MovieInfoViewModel> movieToMovieModelConverter, Converter<MovieInfoViewModel, MovieInfo> movieModelToMovieConverter)
    {
        m_movieRepository = movieRepository;
        m_movieToMovieModelConverter = movieToMovieModelConverter;
        m_movieModelToMovieConverter = movieModelToMovieConverter;
    }

    @Override
    public MovieInfoViewModel save(MovieInfoViewModel movieInfoViewModel)
    {
        m_movieRepository.save(m_movieModelToMovieConverter.convert(movieInfoViewModel));

        return movieInfoViewModel;
    }

    @Override
    public Collection<MovieInfoViewModel> getMovies()
    {
        return StreamSupport.stream(m_movieRepository.findAll().spliterator(), false)
                            .map(movieInfo -> m_movieToMovieModelConverter.convert(movieInfo))
                            .collect(Collectors.toList());
    }

    @Override
    public Optional<MovieInfoViewModel> getById(long id)
    {
        var optionalMovie = m_movieRepository.findById(id);

        return optionalMovie.isPresent() ? Optional.of(m_movieToMovieModelConverter.convert(optionalMovie.get()))
                : Optional.empty();


    }
}
