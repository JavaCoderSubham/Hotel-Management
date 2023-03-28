package com.review.microservice.service;

import com.review.microservice.entity.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAll();
    Review getById(String id);
    Review create(Review review);
    Review update(String id, Review review);
    void deleteById(String id);
}
