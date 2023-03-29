package com.hotel.management.controller;

import com.hotel.management.entity.Hotel;
import com.hotel.management.feign.HotelFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/feign")
public class HotelManagerController {

    @Autowired
    private HotelFeign hotelFeign;

    @GetMapping("/getAll")
    public ResponseEntity<List<Hotel>> getAll() {
        ResponseEntity<List<Hotel>> all = hotelFeign.getAll();
        return all;
    }

}
