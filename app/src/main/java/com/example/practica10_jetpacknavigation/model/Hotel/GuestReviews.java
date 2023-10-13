package com.example.practica10_jetpacknavigation.model.Hotel;

public class GuestReviews {
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
}
