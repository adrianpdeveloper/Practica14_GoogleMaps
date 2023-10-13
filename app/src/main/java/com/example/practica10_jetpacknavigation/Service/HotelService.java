package com.example.practica10_jetpacknavigation.Service;

import com.example.practica10_jetpacknavigation.model.Hotel.HotelResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HotelService {
    @GET("listHotels")
    Call<HotelResponse> getApiResponse();

}
