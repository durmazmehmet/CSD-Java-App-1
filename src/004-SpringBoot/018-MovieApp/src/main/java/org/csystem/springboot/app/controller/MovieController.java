package org.csystem.springboot.app.controller;

import org.csystem.springboot.app.entity.MovieInfo;
import org.csystem.springboot.app.service.IMovieRestService;
import org.csystem.springboot.app.service.IMovieService;
import org.csystem.springboot.app.viewmodel.MovieInfoViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private IMovieService m_movieService;

    @GetMapping
    public String index()
    {
        return "index";
    }

    @PostMapping("/moviesubmit")
    public String movieSubmit(@ModelAttribute MovieInfoViewModel movie, Model model)
    {
        m_movieService.save(movie);

        model.addAttribute("movie", movie);

        return "movies/result";
    }

    @GetMapping("/movie.html")
    public String movieForm(Model model)
    {
        model.addAttribute("movie", new MovieInfoViewModel());

        return "movies/movieform";
    }

    @GetMapping("/movies.html")
    public String getMovies(Model model)
    {
        model.addAttribute("movies", m_movieService.getMovies());

        return "movies/list";
    }

    @GetMapping(value = "/moviedetails", params =  {"id"})
    public String getMovieById(@RequestParam("id") long movieId, Model model)
    {
        var movie = m_movieService.getById(movieId);

        model.addAttribute("movie", movie.isPresent() ? movie.get() : null);

        return "movies/details";
    }
}
