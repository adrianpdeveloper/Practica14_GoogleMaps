package com.example.practica10_jetpacknavigation.model.Hotel;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.example.practica10_jetpacknavigation.model.Hotel.Hotel;

import java.util.List;

public class HotelResponse implements Parcelable {
    private int totalCount;
    private List<Hotel> results;

    public HotelResponse() {
    }

    public HotelResponse(int totalCount, List<Hotel> results) {
        this.totalCount = totalCount;
        this.results = results;
    }

    protected HotelResponse(Parcel in) {
        totalCount = in.readInt();
        results = in.createTypedArrayList(Hotel.CREATOR);
    }

    public static final Creator<HotelResponse> CREATOR = new Creator<HotelResponse>() {
        @Override
        public HotelResponse createFromParcel(Parcel in) {
            return new HotelResponse(in);
        }

        @Override
        public HotelResponse[] newArray(int size) {
            return new HotelResponse[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(totalCount);
        parcel.writeTypedList(results);
    }
}
