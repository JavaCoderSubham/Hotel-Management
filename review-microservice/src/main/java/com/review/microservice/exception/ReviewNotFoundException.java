package com.review.microservice.exception;

import com.review.microservice.entity.Review;

public class ReviewNotFoundException extends RuntimeException {
    public ReviewNotFoundException() {
        super("Review Not Found Exception");
    }
    public ReviewNotFoundException(String message) {
        super(message);
    }
}
