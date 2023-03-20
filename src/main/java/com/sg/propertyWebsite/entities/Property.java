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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Property property)) return false;

        if (getPropertyID() != property.getPropertyID()) return false;
        if (Double.compare(property.getRating(), getRating()) != 0) return false;
        if (Double.compare(property.getPerNightCost(), getPerNightCost()) != 0) return false;
        if (getAmmenitiesID() != property.getAmmenitiesID()) return false;
        if (getCapacity() != property.getCapacity()) return false;
        if (getPropertyName() != null ? !getPropertyName().equals(property.getPropertyName()) : property.getPropertyName() != null)
            return false;
        return getPropertyType() != null ? getPropertyType().equals(property.getPropertyType()) : property.getPropertyType() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getPropertyID();
        result = 31 * result + (getPropertyName() != null ? getPropertyName().hashCode() : 0);
        temp = Double.doubleToLongBits(getRating());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getPerNightCost());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getAmmenitiesID();
        result = 31 * result + (getPropertyType() != null ? getPropertyType().hashCode() : 0);
        result = 31 * result + getCapacity();
        return result;
    }

    @Override
    public String toString() {
        return "Property{" +
                "propertyID=" + propertyID +
                ", propertyName='" + propertyName + '\'' +
                ", rating=" + rating +
                ", perNightCost=" + perNightCost +
                ", ammenitiesID=" + ammenitiesID +
                ", propertyType='" + propertyType + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
