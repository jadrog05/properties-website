package com.sg.propertyWebsite.daos;

import com.sg.propertyWebsite.entities.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class GuestDaoDB implements GuestDao{
    @Autowired
    private JdbcTemplate jdbc;
    @Override
    public Guest getGuestByID(int id) {
        return null;
    }

    @Override
    public List<Guest> getAllGuests() {
        return null;
    }

    @Override
    public Guest addGuest(Guest guest) {
        return null;
    }

    @Override
    public void updateGuest(Guest guest) {

    }

    @Override
    public void deleteGuestByID(int id) {

    }
}
