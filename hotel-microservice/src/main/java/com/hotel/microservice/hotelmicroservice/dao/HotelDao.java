package com.hotel.microservice.hotelmicroservice.dao;

import com.hotel.microservice.hotelmicroservice.entity.Hotel;

import java.util.List;

public interface HotelDao {

    List<Hotel> getAll();

    Hotel getById(String id);

    Hotel create(Hotel hotel);

    Hotel updateHotel(String id, Hotel hotel);

    void deleteById(String id);

}
