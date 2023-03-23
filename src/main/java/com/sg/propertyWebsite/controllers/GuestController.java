package com.sg.propertyWebsite.controllers;

import com.sg.propertyWebsite.Service.BookingService;
import com.sg.propertyWebsite.daos.BookingDao;
import com.sg.propertyWebsite.daos.BookingDaoDB;
import com.sg.propertyWebsite.daos.GuestDaoDB;
import com.sg.propertyWebsite.daos.PropertyDaoDB;
import com.sg.propertyWebsite.entities.Amenity;
import com.sg.propertyWebsite.entities.Booking;
import com.sg.propertyWebsite.entities.Guest;
import com.sg.propertyWebsite.entities.Property;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class GuestController {

    @Autowired
    GuestDaoDB guestDao;
    @Autowired
    PropertyDaoDB propertyDao;
    @Autowired
    BookingDaoDB bookingDao;
    @Autowired
    BookingService bookingService;

    @GetMapping("customerBookings")
    public String displayBooking(Model model, String email, @ModelAttribute("b") Booking booking) {
        List<Guest> allGuestBookings = new ArrayList<>();
        List<Property> allPropertyBookings = new ArrayList<>();
        List<Amenity> allAmenityBookings = new ArrayList<>();
        List<Booking> allBookingBookings = new ArrayList<>();

        List<Guest> allGuests = guestDao.getAllGuests();  // Get all guests from DB

        // Loop through to see where email == email
        for (Guest i : allGuests) {
            if (Objects.equals(i.getEmail(), email)) {
                // if email entered matches email on guest account retrieve full guest
                Guest guest = guestDao.getGuestByID(i.getGuestID());

                booking = bookingDao.getBookingByGuestId(i.getGuestID());

                int propertyID = booking.getPropertiesID();
                Property property = propertyDao.getPropertyByID(propertyID);

                List<String> ammenties = propertyDao.getAmmentiesByID(property.getAmmenitiesID());

                booking.setGuestID(i.getGuestID());
                booking.setPropertiesID(propertyID);
                booking = bookingService.calculateTotalCost(booking);

                allGuestBookings.add(guest);
                allPropertyBookings.add(property);
                //allAmenityBookings.add(ammenties);
                allBookingBookings.add(booking);
            }
        }

        // Need to return List of each element
        model.addAttribute("g", allGuestBookings);
        model.addAttribute("p", allPropertyBookings);
        model.addAttribute("a", allAmenityBookings);  // Currently not working as ammenties is a list not a object but I will make another function later
        model.addAttribute("b", allBookingBookings);

        return "customerBookings";
    }


}


