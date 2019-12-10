package com.example.myapplication.model;

import java.io.Serializable;

public class Dob implements Serializable {

    private String age;

    public Dob(String age) {
        this.age = age;
    }

    public Dob() {
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
