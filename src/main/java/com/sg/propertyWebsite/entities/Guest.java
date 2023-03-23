package com.sg.propertyWebsite.entities;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


public class Guest {
    private int guestID;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty
    private String email;
    @NotNull
    @Size(max = 10, min = 10, message = "Mobile number should be of 10 digits")
    private String phoneNumber;
    @NotEmpty
    private String postcode;

    public int getGuestID() {
        return guestID;
    }

    public void setGuestID(int guestID) {
        this.guestID = guestID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Guest guest)) return false;

        if (getGuestID() != guest.getGuestID()) return false;
        if (getFirstName() != null ? !getFirstName().equals(guest.getFirstName()) : guest.getFirstName() != null)
            return false;
        if (getLastName() != null ? !getLastName().equals(guest.getLastName()) : guest.getLastName() != null)
            return false;
        if (getEmail() != null ? !getEmail().equals(guest.getEmail()) : guest.getEmail() != null) return false;
        if (getPhoneNumber() != null ? !getPhoneNumber().equals(guest.getPhoneNumber()) : guest.getPhoneNumber() != null)
            return false;
        return getPostcode() != null ? getPostcode().equals(guest.getPostcode()) : guest.getPostcode() == null;
    }

    @Override
    public int hashCode() {
        int result = getGuestID();
        result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getPhoneNumber() != null ? getPhoneNumber().hashCode() : 0);
        result = 31 * result + (getPostcode() != null ? getPostcode().hashCode() : 0);
        return result;
    }
}
