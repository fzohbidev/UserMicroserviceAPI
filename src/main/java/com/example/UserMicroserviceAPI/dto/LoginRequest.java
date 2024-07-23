package com.example.UserMicroserviceAPI.dto;

public class LoginRequest {
    private String username;
    private String password;

    //instead of getters and setters we can make use of lombok

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
