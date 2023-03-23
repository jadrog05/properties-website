package com.sg.propertyWebsite.daos;

import com.sg.propertyWebsite.entities.Guest;

import java.util.List;

public interface GuestDao {

    Guest getGuestByID(int id);

    Guest getGuestByEmail(String email);

    List<Guest> getAllGuests();

    Guest addGuest(Guest guest);

    void updateGuest(Guest guest);

    void deleteGuestByID(int id);
}
