package com.example.practica10_jetpacknavigation.model.Hotel;

public class Hotel {
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
}


