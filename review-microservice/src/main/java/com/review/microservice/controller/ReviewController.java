package com.review.microservice.controller;

import com.review.microservice.entity.Review;
import com.review.microservice.service.ReviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ReviewService service;

    @GetMapping("/getAll")
    public ResponseEntity<List<Review>> getAll() {
        log.info("================ Get All Method Start ================");
        log.info("getAll() -> | ");
        List<Review> getAll = service.getAll();
        log.info("getAll() -> | List Review : {}",getAll);
        log.info("================ Get All Method End ================");
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(getAll);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Review> getById(@PathVariable String id) {
        log.info("================ Get By Id Method Start ================");
        log.info("getById() -> | Id : {}",id);
        Review get = service.getById(id);
        log.info("getById() -> | Review : {}",get);
        log.info("================ Get By Id Method End ================");
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(get);
    }

    @PostMapping("/create")
    public ResponseEntity<Review> create(@RequestBody Review review) {
        log.info("create(Review) -> | Review : {}",review);
        Review save = service.create(review);
        log.info("create(Review) -> | Review : {}",save);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(save);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Review> update(@PathVariable String id, Review review) {
        log.info("update(String,Review) -> | Id : {} | Review : {}",id,review);
        Review update = service.update(id, review);
        log.info("update(String,Review) -> | Review : {}",update);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(update);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        log.info("deleteById(String) -> | Id : {}",id);
        service.deleteById(id);
        log.info("deleteById(String) -> | Id : {} | Deleted...",id);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Id : "+id+" Deleted...");
    }

}
