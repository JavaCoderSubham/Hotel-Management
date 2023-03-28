package com.hotel.microservice.hotelmicroservice.controller;

import com.hotel.microservice.hotelmicroservice.entity.Hotel;
import com.hotel.microservice.hotelmicroservice.service.HotelService;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService service;

    @GetMapping("/getall")
    public ResponseEntity<List<Hotel>> getAll() {
        log.info("================= Get All Method Start =================");
        log.info("getAll() -> | ");
        List<Hotel> get = service.getAll();
        log.info("getAll() -> | List Hotel : {}",get);
        log.info("================= Get All Method end =================");
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(get);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Hotel> getById(@PathVariable String id) {
        log.info("================= Get By Id Method Start =================");
        log.info("getById(String) -> | Id : {}",id);
        Hotel hotel = service.getById(id);
        log.info("getById(String) -> | Hotel : {}",hotel);
        log.info("================= Get By Id Method End =================");
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(hotel);
    }

    @PostMapping("/create")
    public ResponseEntity<Hotel> create(@RequestBody Hotel hotel) {
        log.info("================= Create Method Start =================");
        log.info("create(Hotel) -> | Hotel : {}",hotel);
        Hotel get = service.create(hotel);
        log.info("create(Hotel) -> | Hotel : {}",get);
        log.info("================= Create Method End =================");
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(get);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Hotel> update(@PathVariable String id, @RequestBody Hotel hotel) {
        log.info("================= Update Method Start =================");
        log.info("update(String,Hotel) -> | Id : {} | Hotel : {}",id,hotel);
        Hotel get = service.updateHotel(id,hotel);
        log.info("update(String,Hotel) -> | Id : {} | Hotel : {}",id,hotel);
        log.info("================= Update Method End =================");
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(get);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        log.info("================= Delete By Id Method Start =================");
        log.info("deleteById(String) -> | Id : {}",id);
        service.deleteById(id);
        log.info("deleteById(String) -> | Id : {} | Deleted...",id);
        log.info("================= Delete By Id Method End =================");
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Id : "+id+" Hotel Deleted...");
    }

}
