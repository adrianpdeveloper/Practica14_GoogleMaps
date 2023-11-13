package com.example.practica10_jetpacknavigation.model.Hotel;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Address implements Parcelable {
    private String streetAddress;
    private String extendedAddress;
    private String locality;
    private String postalCode;
    private String region;
    private String countryName;
    private String countryCode;
    private boolean obfuscate;

    protected Address(Parcel in) {
        streetAddress = in.readString();
        extendedAddress = in.readString();
        locality = in.readString();
        postalCode = in.readString();
        region = in.readString();
        countryName = in.readString();
        countryCode = in.readString();
        obfuscate = in.readByte() != 0;
    }

    public static final Creator<Address> CREATOR = new Creator<Address>() {
        @Override
        public Address createFromParcel(Parcel in) {
            return new Address(in);
        }

        @Override
        public Address[] newArray(int size) {
            return new Address[size];
        }
    };

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getExtendedAddress() {
        return extendedAddress;
    }

    public void setExtendedAddress(String extendedAddress) {
        this.extendedAddress = extendedAddress;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public boolean isObfuscate() {
        return obfuscate;
    }

    public void setObfuscate(boolean obfuscate) {
        this.obfuscate = obfuscate;
    }

    public Address() {
    }

    public Address(String streetAddress, String extendedAddress, String locality, String postalCode, String region, String countryName, String countryCode, boolean obfuscate) {
        this.streetAddress = streetAddress;
        this.extendedAddress = extendedAddress;
        this.locality = locality;
        this.postalCode = postalCode;
        this.region = region;
        this.countryName = countryName;
        this.countryCode = countryCode;
        this.obfuscate = obfuscate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(streetAddress);
        parcel.writeString(extendedAddress);
        parcel.writeString(locality);
        parcel.writeString(postalCode);
        parcel.writeString(region);
        parcel.writeString(countryName);
        parcel.writeString(countryCode);
        parcel.writeByte((byte) (obfuscate ? 1 : 0));
    }
}
