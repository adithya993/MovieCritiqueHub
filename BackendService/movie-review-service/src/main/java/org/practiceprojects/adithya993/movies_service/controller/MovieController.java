package org.practiceprojects.adithya993.movies_service.controller;

import org.bson.types.ObjectId;
import org.practiceprojects.adithya993.movies_service.resource.Movie;
import org.practiceprojects.adithya993.movies_service.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> allMovies(){
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }

    @GetMapping("/objectId/{id}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable ObjectId id){
        return new ResponseEntity<Optional<Movie>>(movieService.allSpecificMovie(id), HttpStatus.OK);
    }

    @GetMapping("/imdbId/{imdbId}")
    public ResponseEntity<Optional<Movie>> getSingleMovieByImdbId(@PathVariable String imdbId){
        return new ResponseEntity<Optional<Movie>>(movieService.allSpecificMovieByImdbId(imdbId), HttpStatus.OK);
    }
}
