package org.csystem.springboot.app.converter;

import org.csystem.springboot.app.entity.MovieInfo;
import org.csystem.springboot.app.viewmodel.MovieInfoViewModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class MovieInfoToMovieInfoViewModel implements Converter<MovieInfo, MovieInfoViewModel> {
    @Override
    public MovieInfoViewModel convert(MovieInfo movieInfo)
    {
        var viewModel = new MovieInfoViewModel();

        viewModel.setId(movieInfo.getId());
        viewModel.setName(movieInfo.getName());
        viewModel.setType(movieInfo.getType());
        viewModel.setDirector(movieInfo.getDirector());
        viewModel.setDuration(movieInfo.getDuration());
        viewModel.setDate(movieInfo.getDate());

        return viewModel;
    }
}
