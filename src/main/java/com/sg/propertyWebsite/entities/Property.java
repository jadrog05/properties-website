package com.sg.propertyWebsite.entities;

public class Property {
    private int propertyID;
    private String propertyName;
    private double rating;
    private double perNightCost;
    private int ammenitiesID;
    private String propertyType;
    private int capacity;

    public int getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(int propertyID) {
        this.propertyID = propertyID;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getPerNightCost() {
        return perNightCost;
    }

    public void setPerNightCost(double perNightCost) {
        this.perNightCost = perNightCost;
    }

    public int getAmmenitiesID() {
        return ammenitiesID;
    }

    public void setAmmenitiesID(int ammenitiesID) {
        this.ammenitiesID = ammenitiesID;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
