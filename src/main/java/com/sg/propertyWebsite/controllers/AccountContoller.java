package com.sg.propertyWebsite.controllers;

import com.sg.propertyWebsite.daos.BookingDao;
import com.sg.propertyWebsite.daos.GuestDao;
import com.sg.propertyWebsite.daos.PropertyDao;
import com.sg.propertyWebsite.entities.Property;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AccountContoller {

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

    @GetMapping("searchProperty")
    public String searchProperty(Model model) {
        // Temp method to see if gathers from DB
        List<Property> propertyList = propertyDao.getAllProperties();
        model.addAttribute("propertyList", propertyList);
        return "redirect:/properties";
    }
    

}
