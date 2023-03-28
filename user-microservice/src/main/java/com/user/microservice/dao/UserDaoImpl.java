package com.user.microservice.dao;

import com.user.microservice.entity.UserDetails;
import com.user.microservice.exception.UserNotFoundException;
import com.user.microservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Slf4j
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserRepository repository;

    @Override
    public List<UserDetails> getAll() {
        log.info("getAll() -> | ");
        List<UserDetails> all = repository.findAll();
        log.info("getAll() -> | List UserDetails : {}",all);
        return all;
    }

    @Override
    public UserDetails getById(String id) {
        log.info("getById(String) -> | Id : {}",id);
        UserDetails user = repository.findById(id).orElseThrow(() -> new UserNotFoundException("id : " + id + " Not Found"));
        log.info("getById(String) -> | UserDetails : {}",user);
        return user;
    }

    @Override
    public UserDetails create(UserDetails userDetails) {
        log.info("create(UserDetails) -> | UserDetails : {}",userDetails);
        userDetails.setUserId(UUID.randomUUID().toString());
        log.info("create(UserDetails) -> | UserDetails : {}",userDetails);
        UserDetails save = repository.save(userDetails);
        log.info("create(UserDetails) -> | UserDetails : {}",save);
        return save;
    }

    @Override
    public UserDetails update(String id, UserDetails userDetails) {
        log.info("update(String,UserDetails) -> | Id : {} | UserDetails : {}",id,userDetails);
        UserDetails get = getById(id);
        log.info("update(String,UserDetails) -> | UserDetails : {}",get);
        get.setNumber(userDetails.getNumber());
        get.setEmail(userDetails.getEmail());
        get.setAddress(userDetails.getAddress());
        get.setLastName(userDetails.getLastName());
        get.setFirstName(userDetails.getFirstName());
        log.info("update(String,UserDetails) -> | UserDetails : {}",get);
        UserDetails save = repository.save(userDetails);
        log.info("update(String,UserDetails) -> | UserDetails : {}",save);
        return save;
    }

    @Override
    public void deleteById(String id) {
        log.info("deleteById(String) -> | Id : {}",id);
        repository.deleteById(id);
        log.info("deleteById(String) -> | Id : {} | Deleted...",id);
    }
}
