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
        log.info("================ Create Method Start ================");
        log.info("create(Review) -> | Review : {}",review);
        Review save = service.create(review);
        log.info("create(Review) -> | Review : {}",save);
        log.info("================ Create Method End ================");
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(save);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Review> update(@PathVariable String id, Review review) {
        log.info("================ Update Method Start ================");
        log.info("update(String,Review) -> | Id : {} | Review : {}",id,review);
        Review update = service.update(id, review);
        log.info("update(String,Review) -> | Review : {}",update);
        log.info("================ Update Method End ================");
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(update);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        log.info("================ Delete By Id Method Start ================");
        log.info("deleteById(String) -> | Id : {}",id);
        service.deleteById(id);
        log.info("deleteById(String) -> | Id : {} | Deleted...",id);
        log.info("================ Delete By Id Method End ================");
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Id : "+id+" Deleted...");
    }

//    Find Method

    @GetMapping("/findByUser/{id}")
    public ResponseEntity<List<Review>> findByUserId(@PathVariable String id) {
        log.info("==================== Find By UserId Start ====================");
        log.info("findByUserId(String) -> | Id : {}",id);
        List<Review> user = service.findByUserId(id);
        log.info("findByUserId(String) -> | List Review : {}",user);
        log.info("==================== Find By UserId End ====================");
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(user);
    }

    @GetMapping("/findByHotel/{id}")
    public ResponseEntity<List<Review>> findByHotelId(@PathVariable String id) {
        log.info("==================== Find By HotelId Start ====================");
        log.info("findByHotelId(String) -> | Id : {}",id);
        List<Review> hotel = service.findByHotelId(id);
        log.info("findByHotelId(String) -> | List Review : {}",hotel);
        log.info("==================== Find By UserId End ====================");
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(hotel);
    }

    @GetMapping("/findByUserAndHotel/{userId}/{hotelId}")
    public ResponseEntity<List<Review>> findByUserIdAndHotelId(@PathVariable String userId,@PathVariable String hotelId) {
        log.info("==================== Find By UserId And HotelId Start ====================");
        log.info("findByUserIdAndHotelId(String,String) -> | UserId : {} | HotelId : {}",userId,hotelId);
        List<Review> userAndHotel = service.findByUserIdAndHotelId(userId, hotelId);
        log.info("findByUserIdAndHotelId(String,String) -> | List Review : {}",userAndHotel);
        log.info("==================== Find By UserId And HotelId End ====================");
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(userAndHotel);
    }
}
