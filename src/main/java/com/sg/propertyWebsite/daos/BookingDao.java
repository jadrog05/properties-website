package com.sg.propertyWebsite.daos;

import com.sg.propertyWebsite.entities.Booking;

import java.util.List;

public interface BookingDao {
    Booking getBookingByID(int id);

    List<Booking> getAllBooking();

    Booking addBooking(Booking booking);

    void updateBooking(Booking booking);

    void deleteBookingByID(int id);
}
