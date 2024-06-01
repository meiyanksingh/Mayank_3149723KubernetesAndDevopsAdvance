package com.mks.nagp.database.controller;

import com.mks.nagp.database.document.Movie;
import com.mks.nagp.database.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/{name}")
    public Movie getMovieByName(@PathVariable String name) {
        return movieService.getMovieByName(name);
    }

    @PostMapping("/insert")
    public Movie createMovie(@RequestBody Movie movie) {
        return movieService.createMovie(movie);
    }

    @GetMapping("/")
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @DeleteMapping("/deleteAllData")
    public ResponseEntity<String> deleteAllData() {
        movieService.deleteAllData();
        return ResponseEntity.ok("All data deleted successfully.");
    }
}
