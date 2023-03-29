package com.hotel.management.feign;

import com.hotel.management.entity.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "HOTEL-MANAGEMENT")
public interface HotelFeign {

    @GetMapping("/hotel/getall")
    ResponseEntity<List<Hotel>> getAll();

    @GetMapping("/hotel/getById/{id}")
    ResponseEntity<Hotel> getById(@PathVariable String id);

    @PostMapping("/hotel/create")
    ResponseEntity<Hotel> create(@RequestBody Hotel hotel);

    @PutMapping("/hotel/update/{id}")
    ResponseEntity<Hotel> update(@PathVariable String id, @RequestBody Hotel hotel);

    @DeleteMapping("/hotel/delete/{id}")
    ResponseEntity<String> deleteById(@PathVariable String id);

}





