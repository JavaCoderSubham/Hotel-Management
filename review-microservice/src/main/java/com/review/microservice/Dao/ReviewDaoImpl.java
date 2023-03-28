package com.review.microservice.Dao;

import com.review.microservice.entity.Review;
import com.review.microservice.exception.ReviewNotFoundException;
import com.review.microservice.repository.ReviewRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Repository
public class ReviewDaoImpl implements ReviewDao{

    @Autowired
    private ReviewRepository repository;

    @Override
    public List<Review> getAll() {
        log.info("getAll() -> | ");
        List<Review> all = repository.findAll();
        log.info("getAll() -> | List Review : {}",all);
        return all;
    }

    @Override
    public Review getById(String id) {
        log.info("getById(String) -> | Id : {}",id);
        Review review = repository.findById(id).orElseThrow(() -> new ReviewNotFoundException("id :" + id + "Not Found"));
        log.info("getById(String) -> | Review : {}",review);
        return review;
    }

    @Override
    public Review create(Review review) {
        log.info("create(Review) -> | Review : {}",review);
        Review save = repository.save(review);
        log.info("create(Review) -> | Review : {}",save);
        return save;
    }

    @Override
    public Review update(String id, Review review) {
        log.info("update(String,Review) -> | Id : {} | Review : {}",id,review);
        Review byId = getById(id);
        log.info("update(String,Review) -> | Review : {}",byId);
        byId.setRating(review.getRating());
        byId.setCommand(review.getCommand());
        log.info("update(String,Review) -> | Review : {}",byId);
        Review save = repository.save(byId);
        log.info("update(String,Review) -> | Review : {}",save);
        return save;
    }

    @Override
    public void deleteById(String id) {
        log.info("deleteById(String) -> | Id : {}",id);
        repository.deleteById(id);
        log.info("deleteById(String) -> | Id : {} | Deleted...",id);
    }
}
