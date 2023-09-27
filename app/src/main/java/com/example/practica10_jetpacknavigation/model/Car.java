package com.example.practica10_jetpacknavigation.model;

import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;

public class Car {
    private String nameCar;
    private float priceCar;
    private boolean favCar;
    private final @ColorRes int colorResCar;
    private final @DrawableRes int imgResCar;

    public Car(int colorResCar, int imgResCar) {
        this.colorResCar = colorResCar;
        this.imgResCar = imgResCar;
    }

    public Car(String nameCar, float priceCar, boolean favCar, int colorResCar, int imgResCar) {
        this.nameCar = nameCar;
        this.priceCar = priceCar;
        this.favCar = favCar;
        this.colorResCar = colorResCar;
        this.imgResCar = imgResCar;
    }

    public String getNameCar() {
        return nameCar;
    }

    public void setNameCar(String nameCar) {
        this.nameCar = nameCar;
    }

    public float getPriceCar() {
        return priceCar;
    }

    public void setPriceCar(float priceCar) {
        this.priceCar = priceCar;
    }

    public boolean isFavCar() {
        return favCar;
    }

    public void setFavCar(boolean favCar) {
        this.favCar = favCar;
    }

    @ColorRes
    public int getColorResCar() {
        return colorResCar;
    }
    @DrawableRes
    public int getImgResCar() {
        return imgResCar;
    }
}
