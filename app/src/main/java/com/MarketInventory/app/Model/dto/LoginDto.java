package com.MarketInventory.app.Model.dto;

public class LoginDto {
    private String username;
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String password;
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginDto(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
