package com.mks.nagp.database.service;
import com.mks.nagp.database.document.Movie;
import com.mks.nagp.database.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Movie getMovieByName(String name) {
        return movieRepository.findByName(name);
    }

    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public void deleteAllData() {
        movieRepository.deleteAll();
    }
}

