package com.user.microservice.service;

import com.user.microservice.dao.UserDao;
import com.user.microservice.entity.UserDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    @Override
    public List<UserDetails> getAll() {
        log.info("getAll() -> | ");
        List<UserDetails> all = dao.getAll();
        log.info("getAll() -> | List UserDetails : {}",all);
        return all;
    }

    @Override
    public UserDetails getById(String id) {
        log.info("getById(String) -> | Id : {}",id);
        UserDetails byId = dao.getById(id);
        log.info("getById(String) -> | UserDetails : {}",byId);
        return byId;
    }

    @Override
    public UserDetails create(UserDetails userDetails) {
        log.info("create(UserDetails) -> | UserDetails : {}",userDetails);
        UserDetails userDetails1 = dao.create(userDetails);
        log.info("create(UserDetails) -> | UserDetails : {}",userDetails1);
        return userDetails1;
    }

    @Override
    public UserDetails update(String id, UserDetails userDetails) {
        log.info("update(String,UserDetails) -> | Id : {} | UserDetails : {}",id,userDetails);
        UserDetails update = dao.update(id, userDetails);
        log.info("update(String,UserDetails) -> | UserDetails : {}",userDetails);
        return update;
    }

    @Override
    public void deleteById(String id) {
        log.info("deleteById(String) -> | Id : {}",id);
        dao.deleteById(id);
        log.info("deleteById(String) -> | Id : {} | Deleted...",id);
    }
}
