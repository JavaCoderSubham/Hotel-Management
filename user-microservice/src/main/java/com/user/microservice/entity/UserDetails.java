package com.user.microservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserDetails {

    @Id
    private String userId;
    private String reviewId;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String number;
    @Column(unique = true)
    private String email;
    private String address;

}
