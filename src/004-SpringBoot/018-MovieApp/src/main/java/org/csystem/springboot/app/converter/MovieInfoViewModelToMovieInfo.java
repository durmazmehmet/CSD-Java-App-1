package org.csystem.springboot.app.converter;

import org.csystem.springboot.app.entity.MovieInfo;
import org.csystem.springboot.app.viewmodel.MovieInfoViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MovieInfoViewModelToMovieInfo implements Converter<MovieInfoViewModel, MovieInfo> {
    @Autowired
    private ModelMapper m_modelMapper;

    @Override
    public MovieInfo convert(MovieInfoViewModel movieInfoViewModel)
    {
        return m_modelMapper.map(movieInfoViewModel, MovieInfo.class);
    }
}
