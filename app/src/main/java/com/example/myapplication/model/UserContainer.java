package com.example.myapplication.model;

import java.io.Serializable;
import java.util.List;

public class UserContainer implements Serializable {

    private List<User> results;

    public UserContainer(){

    }

    public UserContainer (List<User> results){
        this.results =results;

    }

    public List<User> getResults() {
        return results;
    }

    public void setData(List<User> results) {
        this.results = results;
    }
}
