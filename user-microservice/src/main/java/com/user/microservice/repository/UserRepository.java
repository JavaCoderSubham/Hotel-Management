package com.user.microservice.repository;

import com.user.microservice.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDetails, String> {
}
