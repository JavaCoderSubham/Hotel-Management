package com.hotel.microservice.hotelmicroservice.service;

import com.hotel.microservice.hotelmicroservice.dao.HotelDao;
import com.hotel.microservice.hotelmicroservice.entity.Hotel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class HotelServiceImpl implements HotelService{

    @Autowired
    private HotelDao dao;

    @Override
    public List<Hotel> getAll() {
        log.info("getAll() -> | ");
        List<Hotel> all = dao.getAll();
        log.info("getAll() -> | List Hotel : {}",all);
        return all;
    }

    @Override
    public Hotel getById(String id) {
        log.info("getById(String) -> | id : {}",id);
        Hotel byId = dao.getById(id);
        log.info("getById(String) -> | Hotel : {}",byId);
        return byId;
    }

    @Override
    public Hotel create(Hotel hotel) {
        log.info("create(Hotel) -> | Hotel : {}",hotel);
        Hotel hotel1 = dao.create(hotel);
        log.info("create(Hotel) -> | Hotel : {}",hotel1);
        return hotel1;
    }

    @Override
    public Hotel updateHotel(String id, Hotel hotel) {
        log.info("updateHotel(String,Hotel) -> | Id : {} | Hotel : {}",id,hotel);
        Hotel hotel1 = dao.updateHotel(id, hotel);
        log.info("updateHotel(String,Hotel) -> | Hotel : {}",hotel1);
        return hotel1;
    }

    @Override
    public void deleteById(String id) {
        log.info("deleteById(String) -> | Id : {}",id);
        dao.deleteById(id);
        log.info("deleteById(String) -> | Id : {} | Deleted...",id);
    }
}
