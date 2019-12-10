package com.example.myapplication.model;

import java.io.Serializable;

public class Picture implements Serializable {

    private String large;

    public Picture(String large) {
        this.large = large;
    }

    public Picture() {
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }
}
