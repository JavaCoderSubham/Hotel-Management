package com.hotel.microservice.hotelmicroservice.dao;

import com.hotel.microservice.hotelmicroservice.entity.Hotel;
import com.hotel.microservice.hotelmicroservice.repository.HotelRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class HotelDaoImpl implements HotelDao {

    @Autowired
    private HotelRepository repository;

    @Override
    public List<Hotel> getAll() {
        log.info("getAll() -> | ");
        List<Hotel> all = repository.findAll();
        log.info("getAll() -> | List Hotel : {}",all);
        return all;
    }

    @Override
    public Hotel getById(String id) {
        log.info("getById(String) -> | Id : {}",id);
        Hotel hotel = repository.findById(id).orElse(null);
        log.info("getById(String) -> | Hotel : {}",hotel);
        return hotel;
    }

    @Override
    public Hotel create(Hotel hotel) {
        log.info("create(Hotel) -> | Hotel : {}",hotel);
        hotel.setHotelId(UUID.randomUUID().toString());
        log.info("create(Hotel) -> | Hotel : {}",hotel);
        Hotel save = repository.save(hotel);
        log.info("create(Hotel) -> | Hotel : {}",save);
        return save;
    }

    @Override
    public Hotel updateHotel(String id, Hotel hotel) {

        log.info("updateHotel(String,Hotel) -> | Id : {} | Hotel : {}",id,hotel);
        Hotel byId = getById(id);
        log.info("updateHotel(String,Hotel) -> | Hotel : {}",byId);
        byId.setName(hotel.getName());
        byId.setAddress(hotel.getAddress());
        log.info("updateHotel(String,Hotel) -> | Hotel : {}",byId);
        Hotel save = repository.save(byId);
        log.info("updateHotel(String,Hotel) -> | Hotel : {}",save);
        return save;
    }

    @Override
    public void deleteById(String id) {
        log.info("deleteById(String) -> | id : {}",id);
        repository.deleteById(id);
        log.info("deleteById(String) -> | Deleted...");
    }
}
