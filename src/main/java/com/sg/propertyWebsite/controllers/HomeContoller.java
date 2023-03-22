package com.sg.propertyWebsite.controllers;

import com.sg.propertyWebsite.daos.BookingDao;
import com.sg.propertyWebsite.daos.GuestDao;
import com.sg.propertyWebsite.daos.PropertyDao;
import com.sg.propertyWebsite.entities.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class HomeContoller {

    @Autowired
    BookingDao bookingDao;

    @Autowired
    GuestDao guestDao;

    @Autowired
    PropertyDao propertyDao;

    @GetMapping("/index")
    public void getIndex(Model model) {
        List<Property> propertyList = propertyDao.getAllProperties();

        // Ignore duplicate locations from list
        Set<String> uniqueLocations = new HashSet<>();

        for (Property property : propertyList) {
            if (uniqueLocations.contains(property.getPropertyLocation())) {
                // Location is already populated in drop-down, skip.
                continue;
            }
            uniqueLocations.add(property.getPropertyLocation());
        }
        
        model.addAttribute("properties", uniqueLocations);
    }

    @GetMapping("signin")
    public void getSignin(Model model) {
    }

    @GetMapping("properties")
    public String searchProperty(Model model, String propertyLocation) {
        List<Property> propertyList = propertyDao.getPropertyByLocation(propertyLocation);
        model.addAttribute("properties", propertyList);

        // Create empty property object and set location so can be passed to HTML
        Property property = new Property();
        property.setPropertyLocation(propertyLocation);
        model.addAttribute("property", property);

        model.addAttribute("numberOfProperties", propertyList.size());

        return "properties";
    }

    @GetMapping("allProperties")
    public String displayAllProperties(Model model) {
        List<Property> propertyList = propertyDao.getAllProperties();
        model.addAttribute("properties", propertyList);
        return "allProperties";
    }


}
