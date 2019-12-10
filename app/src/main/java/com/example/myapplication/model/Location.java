package com.example.myapplication.model;

import java.io.Serializable;

public class Location implements Serializable {

    private Coordinates coordinates;

    public Location(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Location() {
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
