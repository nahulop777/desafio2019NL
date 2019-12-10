package com.example.myapplication.service;

import com.example.myapplication.model.UserContainer;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ServiceUser {


    @GET("api/")
    Call<UserContainer> getResults(@Query("results") Integer results);


}
