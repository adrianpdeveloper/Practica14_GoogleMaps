package com.example.practica10_jetpacknavigation.model.Hotel;

public class RatePlan {
    private Price price;

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public RatePlan(Price price) {
        this.price = price;
    }

    public RatePlan() {
    }
}
