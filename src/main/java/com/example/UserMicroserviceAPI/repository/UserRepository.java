package com.example.UserMicroserviceAPI.repository;

import com.example.UserMicroserviceAPI.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    // Custom queries
}
