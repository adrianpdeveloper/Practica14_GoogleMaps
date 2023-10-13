package com.example.practica10_jetpacknavigation.model.Hotel;

import com.example.practica10_jetpacknavigation.model.Hotel.Hotel;

import java.util.List;

public class HotelResponse {
    private int totalCount;
    private List<Hotel> results;

    public HotelResponse() {
    }

    public HotelResponse(int totalCount, List<Hotel> results) {
        this.totalCount = totalCount;
        this.results = results;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<Hotel> getResult() {
        return results;
    }

    public void setResult(List<Hotel> results) {
        this.results = results;
    }
}
