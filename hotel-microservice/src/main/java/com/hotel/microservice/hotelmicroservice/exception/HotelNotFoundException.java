package com.hotel.microservice.hotelmicroservice.exception;

public class HotelNotFoundException extends RuntimeException{

    public HotelNotFoundException() {
        super("Hotel Not Found Exception.");
    }

}

