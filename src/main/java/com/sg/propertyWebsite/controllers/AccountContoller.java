package com.sg.propertyWebsite.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountContoller {

    @GetMapping("index")
    public void getIndex(Model model) {
    }

    @GetMapping("signin")
    public void getSignin(Model model) {
    }

}
