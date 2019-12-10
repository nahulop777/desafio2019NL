package com.example.myapplication.model;

import java.io.Serializable;

public class Coordinates implements Serializable {

    private Double latitude;
    private Double longitude;


    public Coordinates(Double latitute, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Coordinates() {
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitute(Double latitute) {
        this.latitude = latitute;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
