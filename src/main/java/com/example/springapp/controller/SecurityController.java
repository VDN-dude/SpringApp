package com.example.springapp.controller;

import com.example.springapp.entity.RegistrationForm;
import com.example.springapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class SecurityController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String registerForm(Model model){
        model.addAttribute("regForm", new RegistrationForm());
        return "register";
    }

    @PostMapping("/register")
    public String registerForm(@ModelAttribute("regForm") RegistrationForm regForm){
        userService.save(regForm);
        return "redirect:/login";
    }
}
