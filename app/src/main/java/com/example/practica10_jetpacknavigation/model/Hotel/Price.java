package com.example.practica10_jetpacknavigation.model.Hotel;

public class Price {
    private String current;
    private double exactCurrent;

    public Price() {
    }

    public Price(String current, double exactCurrent) {
        this.current = current;
        this.exactCurrent = exactCurrent;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    public double getExactCurrent() {
        return exactCurrent;
    }

    public void setExactCurrent(double exactCurrent) {
        this.exactCurrent = exactCurrent;
    }
}
