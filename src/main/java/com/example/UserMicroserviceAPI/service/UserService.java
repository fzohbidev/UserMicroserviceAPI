package com.example.UserMicroserviceAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.UserMicroserviceAPI.dto.SignupRequest;
import com.example.UserMicroserviceAPI.model.User;
import com.example.UserMicroserviceAPI.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(SignupRequest signupRequest) {
        if (userRepository.findByUsername(signupRequest.getUsername()).isPresent() ||
            userRepository.findByEmail(signupRequest.getEmail()).isPresent()) {
            throw new RuntimeException("User already exists");
        }
        User user = new User();
        user.setUsername(signupRequest.getUsername());
        user.setEmail(signupRequest.getEmail());
        user.setEnabled(signupRequest.getEnabled());
        user.setAuthority(signupRequest.getAuthorityID());
        user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));

        System.out.println("Authority in SignupRequest: " + signupRequest.getAuthorityID()); // Debug statement
        System.out.println("Authority in User entity: " + user.getAuthority()); // Debug statement

        return userRepository.save(user);
    }
}
