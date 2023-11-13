package com.example.practica10_jetpacknavigation.model.Hotel;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Hotel implements Parcelable {
    private int id;
    private String name;
    private int starRating;
    private Address address;
    private GuestReviews guestReviews;
    private RatePlan ratePlan;
    private String neighbourhood;
    private Coordinate coordinate;
    private String providerType;
    private int supplierHotelId;
    private boolean isAlternative;
    private OptimizedThumbUrls optimizedThumbUrls;

    public Hotel() {
    }

    public Hotel(int id, String name, int starRating, Address address, GuestReviews guestReviews, RatePlan ratePlan, String neighbourhood, Coordinate coordinate, String providerType, int supplierHotelId, boolean isAlternative, OptimizedThumbUrls optimizedThumbUrls) {
        this.id = id;
        this.name = name;
        this.starRating = starRating;
        this.address = address;
        this.guestReviews = guestReviews;
        this.ratePlan = ratePlan;
        this.neighbourhood = neighbourhood;
        this.coordinate = coordinate;
        this.providerType = providerType;
        this.supplierHotelId = supplierHotelId;
        this.isAlternative = isAlternative;
        this.optimizedThumbUrls = optimizedThumbUrls;
    }

    protected Hotel(Parcel in) {
        id = in.readInt();
        name = in.readString();
        starRating = in.readInt();
        neighbourhood = in.readString();
        providerType = in.readString();
        supplierHotelId = in.readInt();
        isAlternative = in.readByte() != 0;
    }

    public static final Creator<Hotel> CREATOR = new Creator<Hotel>() {
        @Override
        public Hotel createFromParcel(Parcel in) {
            return new Hotel(in);
        }

        @Override
        public Hotel[] newArray(int size) {
            return new Hotel[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStarRating() {
        return starRating;
    }

    public void setStarRating(int starRating) {
        this.starRating = starRating;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public GuestReviews getGuestReviews() {
        return guestReviews;
    }

    public void setGuestReviews(GuestReviews guestReviews) {
        this.guestReviews = guestReviews;
    }

    public RatePlan getRatePlan() {
        return ratePlan;
    }

    public void setRatePlan(RatePlan ratePlan) {
        this.ratePlan = ratePlan;
    }

    public String getNeighbourhood() {
        return neighbourhood;
    }

    public void setNeighbourhood(String neighbourhood) {
        this.neighbourhood = neighbourhood;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public String getProviderType() {
        return providerType;
    }

    public void setProviderType(String providerType) {
        this.providerType = providerType;
    }

    public int getSupplierHotelId() {
        return supplierHotelId;
    }

    public void setSupplierHotelId(int supplierHotelId) {
        this.supplierHotelId = supplierHotelId;
    }

    public boolean isAlternative() {
        return isAlternative;
    }

    public void setAlternative(boolean alternative) {
        isAlternative = alternative;
    }

    public OptimizedThumbUrls getOptimizedThumbUrls() {
        return optimizedThumbUrls;
    }

    public void setOptimizedThumbUrls(OptimizedThumbUrls optimizedThumbUrls) {
        this.optimizedThumbUrls = optimizedThumbUrls;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeInt(starRating);
        parcel.writeString(neighbourhood);
        parcel.writeString(providerType);
        parcel.writeInt(supplierHotelId);
        parcel.writeByte((byte) (isAlternative ? 1 : 0));
    }
}


