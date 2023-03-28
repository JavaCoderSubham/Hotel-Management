package com.hotel.microservice.hotelmicroservice.repository;

import com.hotel.microservice.hotelmicroservice.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, String> {

}
