package com.example.myapplication.model;

import java.io.Serializable;

public class Login implements Serializable {

    private String username;

    public Login(String username) {
        this.username = username;
    }

    public Login() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
