package com.review.microservice.repository;

import com.review.microservice.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, String> {

}
