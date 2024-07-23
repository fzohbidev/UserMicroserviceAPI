package com.example.UserMicroserviceAPI;

import com.example.UserMicroserviceAPI.controller.AuthController;
import com.example.UserMicroserviceAPI.dto.LoginRequest;
import com.example.UserMicroserviceAPI.jwt.JwtUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class AuthControllerTest {

    @Autowired
    private AuthController authController;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtUtils jwtUtils;

    @Test
    public void contextLoads() throws Exception {
        assertThat(authController).isNotNull();
    }

    @Test
    public void testAuthenticateUser() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("user");
        loginRequest.setPassword("password");

        ResponseEntity<?> response = authController.authenticateUser(loginRequest);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        UserDetails userDetails = userDetailsService.loadUserByUsername("user");
        String jwtToken = jwtUtils.generateTokenFromUsername(userDetails);
        assertThat(jwtToken).isNotNull();
    }
}