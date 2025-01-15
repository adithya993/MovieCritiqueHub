package org.practiceprojects.adithya993.movies_service.repository;

import org.bson.types.ObjectId;
import org.practiceprojects.adithya993.movies_service.resource.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
    Optional<Movie> findMovieByImdbId(String imdbId);
}
