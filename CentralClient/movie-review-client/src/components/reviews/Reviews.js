import { useEffect, useRef } from "react";
import api from '../../api/axiosConfig';
import { useParams } from 'react-router-dom';
import { Container, Row, Col } from 'react-bootstrap';
import ReviewForm from "../reviewForm/reviewForm";

import React from 'react';

const Reviews = ({ getMovieData, movie, reviews, setReviews }) => {
    const revText = useRef();
    let params = useParams();
    const movieId = params.movieId;

    // Fetch movie data and initialize reviews
    useEffect(() => {
        const fetchMovieData = async () => {
            await getMovieData(movieId);
            if (movie?.reviewIds) {
                setReviews(movie.reviewIds); // Load default reviews when movie is fetched
            }
        };
        fetchMovieData();
    }, [movieId]); // Only re-fetch data when movieId changes

    // Add a new review
    const addReview = async (e) => {
        e.preventDefault();

        const rev = revText.current;

        try {
            const response = await api.post("/api/v1/reviews", { reviewBody: rev.value, imdbId: movieId });

            const updatedReviews = [...reviews, { body: rev.value }];

            console.log("Updated Reviews:", updatedReviews);

            rev.value = "";

            setReviews(updatedReviews); // Update reviews state with the new review
        } catch (err) {
            console.error("Error adding review:", err);
        }
    };

    return (
        <div className='react-player-container'>
            <Row>
                <Col><h3>Reviews</h3></Col>
            </Row>
            <Row className="mt-2">
                <Col><img src={movie?.poster} alt="" /></Col>
                <Col>
                    <>
                        <Row>
                            <Col>
                                <ReviewForm handleSubmit={addReview} revText={revText} labelText="Write a Review?" />
                            </Col>
                        </Row>
                        <Row>
                            <Col>
                                <hr />
                            </Col>
                        </Row>
                    </>
                    {Array.isArray(reviews) &&
                        reviews.map((r, index) => (
                            <React.Fragment key={index}>
                                <Row>
                                    <Col>{r.body}</Col>
                                </Row>
                                <Row>
                                    <Col>
                                        <hr />
                                    </Col>
                                </Row>
                            </React.Fragment>
                        ))
                    }
                </Col>
            </Row>
            <Row>
                <Col>
                    <hr />
                </Col>
            </Row>
        </div>
    );
};

export default Reviews;