package com.example.practica10_jetpacknavigation.model.Hotel;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class OptimizedThumbUrls implements Parcelable {
    private String srpDesktop;

    public OptimizedThumbUrls() {
    }

    public OptimizedThumbUrls(String srpDesktop) {
        this.srpDesktop = srpDesktop;
    }

    protected OptimizedThumbUrls(Parcel in) {
        srpDesktop = in.readString();
    }

    public static final Creator<OptimizedThumbUrls> CREATOR = new Creator<OptimizedThumbUrls>() {
        @Override
        public OptimizedThumbUrls createFromParcel(Parcel in) {
            return new OptimizedThumbUrls(in);
        }

        @Override
        public OptimizedThumbUrls[] newArray(int size) {
            return new OptimizedThumbUrls[size];
        }
    };

    public String getSrpDesktop() {
        return srpDesktop;
    }

    public void setSrpDesktop(String srpDesktop) {
        this.srpDesktop = srpDesktop;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(srpDesktop);
    }
}
