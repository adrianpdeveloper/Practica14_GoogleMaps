package com.example.practica10_jetpacknavigation.Service;

import com.example.practica10_jetpacknavigation.model.Hotel.HotelResponse;
import com.example.practica10_jetpacknavigation.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface LoginService {
    @POST("login")
    Call<User> postLogin(@Body User user);

}
