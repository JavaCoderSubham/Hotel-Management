package com.user.microservice.service;

import com.user.microservice.entity.UserDetails;

import java.util.List;

public interface UserService {

    List<UserDetails> getAll();

    UserDetails getById(String id);

    UserDetails create(UserDetails userDetails);

    UserDetails update(String id, UserDetails userDetails);

    void deleteById(String id);

}
