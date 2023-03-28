package com.user.microservice.controller;


import com.user.microservice.entity.UserDetails;
import com.user.microservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/getAll")
    public ResponseEntity<List<UserDetails>> getAll() {
        log.info("getAll() -> | ");
        List<UserDetails> list = service.getAll();
        log.info("getAll() -> | List UserDetails : {}",list);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(list);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<UserDetails> getById(@PathVariable String id) {
        log.info("getById(String) -> | Id : {}",id);
        UserDetails byId = service.getById(id);
        log.info("getById(String) -> | UserDetails : {}",byId);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(byId);
    }

    @PostMapping("/create")
    public ResponseEntity<UserDetails> create(@RequestBody UserDetails user) {
        log.info("create(UserDetails) -> | UserDetails : {}",user);
        UserDetails save = service.create(user);
        log.info("create(UserDetails) -> | UserDetails : {}",save);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(save);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserDetails> update(@PathVariable String id, @RequestBody UserDetails userDetails) {
        log.info("update(String,UserDetails) -> | Id : {} | UserDetails : {}",id,userDetails);
        UserDetails update = service.update(id, userDetails);
        log.info("update(String,UserDetails) -> | UserDetails : {}",userDetails);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(update);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        log.info("deleteById(String) -> | Id : {}",id);
        service.deleteById(id);
        log.info("deleteById(String) -> | Id : {} | Deleted...",id);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("ID : "+id+" Deleted...");
    }
}
