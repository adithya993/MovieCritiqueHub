package org.practiceprojects.adithya993.movies_service.service;

import org.bson.types.ObjectId;
import org.practiceprojects.adithya993.movies_service.repository.MovieRepository;
import org.practiceprojects.adithya993.movies_service.resource.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> allMovies(){
        return movieRepository.findAll();
    }

    public Optional<Movie> allSpecificMovie(ObjectId id) {
        return movieRepository.findById(id);
    }

    public Optional<Movie> allSpecificMovieByImdbId(String imdbId) {
        return movieRepository.findMovieByImdbId(imdbId);
    }
}
