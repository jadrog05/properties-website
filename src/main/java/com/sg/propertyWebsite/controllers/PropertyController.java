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

import java.util.List;

@Controller
public class PropertyController {

    @Autowired
    PropertyDaoDB propertyDao;
    @Autowired
    GuestDaoDB guestDao;
    @Autowired
    BookingDaoDB bookingDao;


/*    @GetMapping("properties")
    public String displayProperties(Model model){
        List<Property> properties = propertyDao.getAllProperties();
        model.addAttribute("properties",properties);
        return "properties";
    }*/

    @GetMapping("propertyDetails")
    public String displayPropertyInfo(int id,Model model){
        Property property = propertyDao.getPropertyByID(id);
        model.addAttribute("property", property);
        return "propertyDetails";
    }
}
