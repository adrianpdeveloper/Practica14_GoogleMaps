package com.example.practica10_jetpacknavigation.model.Hotel;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class GuestReviews implements Parcelable {
    private double unformattedRating;
    private String rating;
    private int total;
    private int scale;
    private String badge;
    private String badgeText;

    public GuestReviews() {
    }

    public GuestReviews(double unformattedRating, String rating, int total, int scale, String badge, String badgeText) {
        this.unformattedRating = unformattedRating;
        this.rating = rating;
        this.total = total;
        this.scale = scale;
        this.badge = badge;
        this.badgeText = badgeText;
    }

    protected GuestReviews(Parcel in) {
        unformattedRating = in.readDouble();
        rating = in.readString();
        total = in.readInt();
        scale = in.readInt();
        badge = in.readString();
        badgeText = in.readString();
    }

    public static final Creator<GuestReviews> CREATOR = new Creator<GuestReviews>() {
        @Override
        public GuestReviews createFromParcel(Parcel in) {
            return new GuestReviews(in);
        }

        @Override
        public GuestReviews[] newArray(int size) {
            return new GuestReviews[size];
        }
    };

    public double getUnformattedRating() {
        return unformattedRating;
    }

    public void setUnformattedRating(double unformattedRating) {
        this.unformattedRating = unformattedRating;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public String getBadge() {
        return badge;
    }

    public void setBadge(String badge) {
        this.badge = badge;
    }

    public String getBadgeText() {
        return badgeText;
    }

    public void setBadgeText(String badgeText) {
        this.badgeText = badgeText;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeDouble(unformattedRating);
        parcel.writeString(rating);
        parcel.writeInt(total);
        parcel.writeInt(scale);
        parcel.writeString(badge);
        parcel.writeString(badgeText);
    }
}
