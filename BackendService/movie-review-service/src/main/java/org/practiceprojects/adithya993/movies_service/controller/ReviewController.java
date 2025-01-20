package org.practiceprojects.adithya993.movies_service.controller;

import org.practiceprojects.adithya993.movies_service.resource.Movie;
import org.practiceprojects.adithya993.movies_service.resource.Review;
import org.practiceprojects.adithya993.movies_service.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Optional<Review>> createReview(@RequestBody Map<String, String> payload){
        return new ResponseEntity<Optional<Review>>(Optional.ofNullable(reviewService.createReview(payload.get("reviewBody"), payload.get("imdbId"))), HttpStatus.CREATED);
    }
}
