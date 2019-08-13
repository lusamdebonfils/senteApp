package edu.mum.cs.cs425.finalproject.senteapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping(value = {"/senteapp/login"})
    public String displayLoginPage() {
        return "home/login";
    }
}
