package com.sg.propertyWebsite.controllers;

import com.sg.propertyWebsite.daos.GuestDaoDB;
import com.sg.propertyWebsite.daos.PropertyDaoDB;
import com.sg.propertyWebsite.entities.Guest;
import com.sg.propertyWebsite.entities.Property;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GuestController {

    @Autowired
    GuestDaoDB guestDao;
    @Autowired
    PropertyDaoDB propertyDao;



}


