package com.review.microservice.service;

import com.review.microservice.Dao.ReviewDao;
import com.review.microservice.entity.Review;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ReviewServiceImpl implements ReviewService{

    @Autowired
    private ReviewDao dao;

    @Override
    public List<Review> getAll() {
        log.info("getAll() -> | ");
        List<Review> all = dao.getAll();
        log.info("getAll() -> | List Review : {}",all);
        return all;
    }

    @Override
    public Review getById(String id) {
        log.info("getById(String) -> | Id : {}",id);
        Review byId = dao.getById(id);
        log.info("getById(String) -> | Review : {}",byId);
        return byId;
    }

    @Override
    public Review create(Review review) {
        log.info("create(Review) -> | Review : {}",review);
        Review save = dao.create(review);
        log.info("create(Review) -> | Review : {}",save);
        return save;
    }

    @Override
    public Review update(String id, Review review) {
        log.info("update(String,Review) -> | Id : {} | Review : {}",id,review);
        Review update = dao.update(id, review);
        log.info("update(String,Review) -> | Review : {}",update);
        return update;
    }

    @Override
    public void deleteById(String id) {
        log.info("deleteById(String) -> | Id : {}",id);
        dao.deleteById(id);
        log.info("deleteById(String) -> | Id : {} | Deleted...",id);
    }
}
