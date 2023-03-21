package com.sg.propertyWebsite.controllers;

import com.sg.propertyWebsite.daos.AccountDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountContoller {

    private AccountDao accountsDao;

    @GetMapping("index")
    public void getIndex(Model model) {
    }

    @GetMapping("signin")
    public void getSignin(Model model) {
    }

}
