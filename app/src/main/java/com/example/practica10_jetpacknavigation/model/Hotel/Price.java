package com.example.practica10_jetpacknavigation.model.Hotel;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Price implements Parcelable {
    private String current;
    private double exactCurrent;

    public Price() {
    }

    public Price(String current, double exactCurrent) {
        this.current = current;
        this.exactCurrent = exactCurrent;
    }

    protected Price(Parcel in) {
        current = in.readString();
        exactCurrent = in.readDouble();
    }

    public static final Creator<Price> CREATOR = new Creator<Price>() {
        @Override
        public Price createFromParcel(Parcel in) {
            return new Price(in);
        }

        @Override
        public Price[] newArray(int size) {
            return new Price[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(current);
        parcel.writeDouble(exactCurrent);
    }
}
