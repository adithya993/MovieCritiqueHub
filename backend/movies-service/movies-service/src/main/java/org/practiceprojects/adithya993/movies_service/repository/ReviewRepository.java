package org.practiceprojects.adithya993.movies_service.repository;

import org.bson.types.ObjectId;
import org.practiceprojects.adithya993.movies_service.resource.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {
}
