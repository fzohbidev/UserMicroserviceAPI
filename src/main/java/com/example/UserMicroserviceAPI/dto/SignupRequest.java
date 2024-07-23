package com.example.UserMicroserviceAPI.dto;

public class SignupRequest {

    private String username;

    private String email;

    private String password;

    private boolean enabled;

    private int authorityID;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setenabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getAuthorityID() {
        return authorityID;
    }

    public void setAuthorityID(int authorityID) {
        this.authorityID = authorityID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
