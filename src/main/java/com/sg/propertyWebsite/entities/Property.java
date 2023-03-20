package com.sg.propertyWebsite.entities;

public class Property {
    private int propertyID;
    private int rooms;
    private int beds;
    private int ammenitiesID;
    private double perNightCost;
    private String description;

    public int getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(int propertyID) {
        this.propertyID = propertyID;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public int getAmmenitiesID() {
        return ammenitiesID;
    }

    public void setAmmenitiesID(int ammenitiesID) {
        this.ammenitiesID = ammenitiesID;
    }

    public double getPerNightCost() {
        return perNightCost;
    }

    public void setPerNightCost(double perNightCost) {
        this.perNightCost = perNightCost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
