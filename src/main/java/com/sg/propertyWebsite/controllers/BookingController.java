package com.sg.propertyWebsite.controllers;

import com.sg.propertyWebsite.Service.BookingService;
import com.sg.propertyWebsite.daos.BookingDaoDB;
import com.sg.propertyWebsite.daos.GuestDaoDB;
import com.sg.propertyWebsite.daos.PropertyDaoDB;
import com.sg.propertyWebsite.entities.Amenity;
import com.sg.propertyWebsite.entities.Booking;
import com.sg.propertyWebsite.entities.Guest;
import com.sg.propertyWebsite.entities.Property;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BookingController {
    @Autowired
    BookingDaoDB bookingDao;
    @Autowired
    GuestDaoDB guestDao;
    @Autowired
    PropertyDaoDB propertyDao;
    @Autowired
    BookingService bookingService;

    @GetMapping("/newGuest")
    public String newGuest(Model model, int propertyID) {
        Guest guest = new Guest();
        Property p = propertyDao.getPropertyByID(propertyID);
        model.addAttribute("g", guest);
        model.addAttribute("p", p);

        return "addGuestForm";
    }

    @PostMapping("/newGuest")
    public String addGuest(Model model, @ModelAttribute("g") Guest g, int propertyID) {
        g = guestDao.addGuest(g);
        Property p = propertyDao.getPropertyByID(propertyID);  // Just want to return propertyID as int
        List<String> a = propertyDao.getAmmentiesByID(propertyID);
        model.addAttribute("p", p);  // Add to model to be used on confirmBooking.html
        Booking b = new Booking();
        model.addAttribute("b", b);
        return "confirmBooking";
    }

    @GetMapping("/confirmBooking")
    public String newBooking(Model model){
        Booking b = new Booking();
        model.addAttribute("b",b);
        return "confirmBooking";
    }

    @PostMapping("/confirmBooking")
    public String addBooking(Model model, @ModelAttribute("b") Booking b, int guestID, int propertyID){
        Guest g = guestDao.getGuestByID(guestID);
        Property p = propertyDao.getPropertyByID(propertyID);
        List<String> a = propertyDao.getAmmentiesByID(p.getAmmenitiesID());
        b.setGuestID(guestID);
        b.setPropertiesID(propertyID);
        b = bookingService.calculateTotalCost(b);
        model.addAttribute("g",g);
        model.addAttribute("p",p);
        model.addAttribute("a",a);
        //model.addAttribute("b",b)
        System.out.println(b.toString());
        b = bookingDao.addBooking(b);
        return "bookingSummary";
    }
}
