package com.example.practica10_jetpacknavigation.model.Hotel;

public class Address {
    private String streetAddress;
    private String extendedAddress;
    private String locality;
    private String postalCode;
    private String region;
    private String countryName;
    private String countryCode;
    private boolean obfuscate;

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
}
