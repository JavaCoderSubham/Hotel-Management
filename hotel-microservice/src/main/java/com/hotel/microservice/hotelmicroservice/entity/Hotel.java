package com.hotel.microservice.hotelmicroservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Hotel {
    @Id
    private String hotelId;
    private String name;
    private String address;

}
