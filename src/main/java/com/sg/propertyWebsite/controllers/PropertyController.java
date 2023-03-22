package com.sg.propertyWebsite.controllers;

import com.sg.propertyWebsite.daos.BookingDaoDB;
import com.sg.propertyWebsite.daos.GuestDaoDB;
import com.sg.propertyWebsite.daos.PropertyDaoDB;
import com.sg.propertyWebsite.entities.Booking;
import com.sg.propertyWebsite.entities.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PropertyController {

    @Autowired
    PropertyDaoDB propertyDao;
    @Autowired
    GuestDaoDB guestDao;
    @Autowired
    BookingDaoDB bookingDao;

    @GetMapping("propertyDetails")
    public String displayPropertyInfo(int id, Model model) {
        Property property = propertyDao.getPropertyByID(id);
        List<String> a = propertyDao.getAmmentiesByID(property.getAmmenitiesID());
        model.addAttribute("property", property);
        model.addAttribute("a", a);
        return "propertyDetails";
    }

    @GetMapping("filter")
    public String newFilter(Model model, String propertyLocation) {
        List<Property> properties = propertyDao.getPropertyByLocation(propertyLocation);

        // Create property object and populate with details filter will need
        Property property = new Property();
        if (!properties.isEmpty()) {
            property.setPropertyLocation(properties.get(0).getPropertyLocation());
        }

        model.addAttribute("property", property);
        return "filter";
    }


}
