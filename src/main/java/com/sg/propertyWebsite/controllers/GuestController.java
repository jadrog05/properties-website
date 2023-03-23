package com.sg.propertyWebsite.controllers;

import com.sg.propertyWebsite.Service.BookingService;
import com.sg.propertyWebsite.daos.BookingDao;
import com.sg.propertyWebsite.daos.BookingDaoDB;
import com.sg.propertyWebsite.daos.GuestDaoDB;
import com.sg.propertyWebsite.daos.PropertyDaoDB;
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

import java.util.List;

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
    public String displayBooking(Model model, String email, @ModelAttribute("b") Booking b) {
        Guest g = guestDao.getGuestByEmail(email);  // THIS WON't WORK IF MORE THAN 1 EMAIL IN DB
        int guestID = g.getGuestID();

        b = bookingDao.getBookingByGuestId(guestID);
        int propertyID = b.getPropertiesID();


        Property p = propertyDao.getPropertyByID(propertyID);
        List<String> a = propertyDao.getAmmentiesByID(p.getAmmenitiesID());

        b.setGuestID(guestID);
        b.setPropertiesID(propertyID);
        b = bookingService.calculateTotalCost(b);
        model.addAttribute("g", g);
        model.addAttribute("p", p);
        model.addAttribute("a", a);
        model.addAttribute("b",b);


        return "customerBookings";
    }

}


