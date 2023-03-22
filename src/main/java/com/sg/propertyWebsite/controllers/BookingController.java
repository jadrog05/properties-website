package com.sg.propertyWebsite.controllers;

import com.sg.propertyWebsite.daos.BookingDaoDB;
import com.sg.propertyWebsite.daos.GuestDaoDB;
import com.sg.propertyWebsite.daos.PropertyDaoDB;
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

@Controller
public class BookingController {
    @Autowired
    BookingDaoDB bookingDao;
    @Autowired
    GuestDaoDB guestDao;
    @Autowired
    PropertyDaoDB propertyDao;


    @GetMapping("/newGuest")
    public String newGuest(Model model, int propertyID){
        Guest guest = new Guest();
        Property p = propertyDao.getPropertyByID(propertyID);
        model.addAttribute("g", guest);
        model.addAttribute("p", p);

    return "addGuestForm";
    }



    @PostMapping("/newGuest")
    public String confirmBooking(@ModelAttribute("g") Guest g, @ModelAttribute("p") Property p){
            g = guestDao.addGuest(g);
        System.out.println(p.toString());
    return "confirmBooking";
    }

}
