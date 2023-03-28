package com.user.microservice.dao;

import com.user.microservice.entity.UserDetails;

import java.util.List;

public interface UserDao {

    List<UserDetails> getAll();

    UserDetails getById(String id);

    UserDetails create(UserDetails userDetails);

    UserDetails update(String id, UserDetails userDetails);

    void deleteById(String id);

}
