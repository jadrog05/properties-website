package com.sg.propertyWebsite.daos;

import com.sg.propertyWebsite.entities.Booking;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookingDaoDB implements BookingDao{
    @Override
    public Booking getBookingByID(int id) {
        return null;
    }

    @Override
    public List<Booking> getAllBooking() {
        return null;
    }

    @Override
    public Booking addBooking(Booking booking) {
        return null;
    }

    @Override
    public void updateBooking(Booking booking) {

    }

    @Override
    public void deleteBookingByID(int id) {

    }
}
