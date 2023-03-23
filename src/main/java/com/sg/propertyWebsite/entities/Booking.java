package com.sg.propertyWebsite.entities;


import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDate;


import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class Booking {
    private int bookingID;
    private int propertiesID;
    private int guestID;

    @NotNull
    @Min(value = 1, message = "You cant have 0 guests")
    private int numberOfGuests;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Future(message = "Start date should be in the future")
    private Date startDate;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Future(message = " End date should be in the future")
    private Date endDate;
    private double totalCost;


    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public int getPropertiesID() {
        return propertiesID;
    }

    public void setPropertiesID(int propertiesID) {
        this.propertiesID = propertiesID;
    }

    public int getGuestID() {
        return guestID;
    }

    public void setGuestID(int guestID) {
        this.guestID = guestID;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setStartDate(String startDate){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date parsed = null;
        try {
            parsed = format.parse(startDate);
        } catch (ParseException e) {
        }
        this.startDate = parsed;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setEndDate(String endDate){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date parsed = null;
        try {
            parsed = format.parse(endDate);
        } catch (ParseException e) {

        }
        this.endDate = parsed;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Booking booking)) return false;

        if (getBookingID() != booking.getBookingID()) return false;
        if (getPropertiesID() != booking.getPropertiesID()) return false;
        if (getGuestID() != booking.getGuestID()) return false;
        if (getNumberOfGuests() != booking.getNumberOfGuests()) return false;
        if (Double.compare(booking.getTotalCost(), getTotalCost()) != 0) return false;
        if (getStartDate() != null ? !getStartDate().equals(booking.getStartDate()) : booking.getStartDate() != null)
            return false;
        return getEndDate() != null ? getEndDate().equals(booking.getEndDate()) : booking.getEndDate() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getBookingID();
        result = 31 * result + getPropertiesID();
        result = 31 * result + getGuestID();
        result = 31 * result + getNumberOfGuests();
        result = 31 * result + (getStartDate() != null ? getStartDate().hashCode() : 0);
        result = 31 * result + (getEndDate() != null ? getEndDate().hashCode() : 0);
        temp = Double.doubleToLongBits(getTotalCost());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingID=" + bookingID +
                ", propertiesID=" + propertiesID +
                ", guestID=" + guestID +
                ", numberOfGuests=" + numberOfGuests +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", totalCost=" + totalCost +
                '}';
    }
}
