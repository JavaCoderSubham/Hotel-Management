package com.hotel.management.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetails {

    private String userId;
    private String firstName;
    private String lastName;
    private String number;
    private String email;
    private String address;

}
