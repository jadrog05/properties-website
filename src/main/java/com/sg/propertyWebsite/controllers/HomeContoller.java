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
    public String searchProperty(Model model, String propertyLocation, int numberOfGuests) {
        List<Property> propertyList = propertyDao.getPropertyByLocation(propertyLocation);

        // Only add properties that meet filter to the Set
        Set<Property> meetsFilter = new HashSet<>();

        // Go through list and check if capacity <= numberOfGuests
        for (Property property : propertyList) {
            if (property.getCapacity() < numberOfGuests) {
                // Not passing the filter, don't add.
                continue;
            }
            meetsFilter.add(property);
        }
        
        model.addAttribute("properties", meetsFilter);

        // Create empty property object and set location so can be passed to HTML
        Property property = new Property();
        property.setPropertyLocation(propertyLocation);
        model.addAttribute("property", property);

        model.addAttribute("numberOfProperties", meetsFilter.size());

        return "properties";
    }

    @GetMapping("allProperties")
    public String displayAllProperties(Model model) {
        List<Property> propertyList = propertyDao.getAllProperties();
        model.addAttribute("properties", propertyList);
        return "allProperties";
    }


}
