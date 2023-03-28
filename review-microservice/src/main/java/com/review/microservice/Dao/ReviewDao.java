package com.review.microservice.Dao;

import com.review.microservice.entity.Review;

import java.util.List;

public interface ReviewDao {

    List<Review> getAll();
    Review getById(String id);
    Review create(Review review);
    Review update(String id, Review review);
    void deleteById(String id);

//    find method
    List<Review> findByUserId(String userId);
    List<Review> findByHotelId(String hotelId);
    List<Review> findByUserIdAndHotelId(String userId, String hotelId);

}
