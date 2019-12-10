package com.example.myapplication.model;

import java.io.Serializable;

public class User implements Serializable {

    private String gender;
    private Login login;
    private Picture picture;
    private Name name;
    private Location location;
    private Dob dob;
    private String email;

    public User(String gender, Login login, Picture picture, Name name, Location location, Dob dob, String email) {
        this.gender = gender;
        this.login = login;
        this.picture = picture;
        this.name = name;
        this.location = location;
        this.dob = dob;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User() {
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Dob getDob() {
        return dob;
    }

    public void setDob(Dob dob) {
        this.dob = dob;
    }
}





