package com.sg.propertyWebsite.controllers;

import com.sg.propertyWebsite.daos.BookingDaoDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookingController {
    @Autowired
    BookingDaoDB bookingDao;

    @GetMapping("addBookingWithID")
    public String addBooking(Model model,int id){
    return "addBookingWithID";
    }

    @PostMapping("addGuest")
    public String addGuest(Model model){
    return "addGuest";
    }
}
