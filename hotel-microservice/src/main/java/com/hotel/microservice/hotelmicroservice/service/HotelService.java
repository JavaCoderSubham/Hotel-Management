package com.hotel.microservice.hotelmicroservice.service;

import com.hotel.microservice.hotelmicroservice.entity.Hotel;

import java.util.List;

public interface HotelService {
    List<Hotel> getAll();

    Hotel getById(String id);

    Hotel create(Hotel hotel);

    Hotel updateHotel(String id, Hotel hotel);

    void deleteById(String id);
}
