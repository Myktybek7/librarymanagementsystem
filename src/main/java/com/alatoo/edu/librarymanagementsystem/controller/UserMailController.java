package com.alatoo.edu.librarymanagementsystem.controller;

import com.alatoo.edu.librarymanagementsystem.entity.UserMail;
import com.alatoo.edu.librarymanagementsystem.service.UserMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserMailController {

    @Autowired
    private UserMailService userMailService;

    @GetMapping("/register-user")
    public String showRegistrationForm(Model model) {
        model.addAttribute("userMail", new UserMail());
        return "register-user";
    }

    @PostMapping("/register-user")
    public String registerUser(@ModelAttribute("userMail") UserMail userMail, Model model) {
        boolean isRegistered = userMailService.registerUser(userMail);
        if (isRegistered) {
            return "redirect:/login";
        } else {
            model.addAttribute("errorMessage", "Email is already taken.");
            return "register-user";
        }
    }
}
