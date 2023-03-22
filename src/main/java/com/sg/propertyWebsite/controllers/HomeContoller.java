package com.sg.propertyWebsite.controllers;

import com.sg.propertyWebsite.daos.BookingDao;
import com.sg.propertyWebsite.daos.GuestDao;
import com.sg.propertyWebsite.daos.PropertyDao;
import com.sg.propertyWebsite.entities.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeContoller {

    @Autowired
    BookingDao bookingDao;

    @Autowired
    GuestDao guestDao;

    @Autowired
    PropertyDao propertyDao;

    @GetMapping("index")
    public void getIndex(Model model) {
    }

    @GetMapping("signin")
    public void getSignin(Model model) {
    }

    @GetMapping("properties")
    public String searchProperty(Model model, String propertyLocation) {
        List<Property> propertyList = propertyDao.getPropertyByLocation(propertyLocation);
        model.addAttribute("properties", propertyList);
        return "properties";
    }


}
