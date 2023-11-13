package com.example.practica10_jetpacknavigation.model.Hotel;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class RatePlan implements Parcelable {
    private Price price;

    protected RatePlan(Parcel in) {
        price = in.readParcelable(Price.class.getClassLoader());
    }

    public static final Creator<RatePlan> CREATOR = new Creator<RatePlan>() {
        @Override
        public RatePlan createFromParcel(Parcel in) {
            return new RatePlan(in);
        }

        @Override
        public RatePlan[] newArray(int size) {
            return new RatePlan[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeParcelable(price, i);
    }
}
