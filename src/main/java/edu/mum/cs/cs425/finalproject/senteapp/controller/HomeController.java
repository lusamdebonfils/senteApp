package edu.mum.cs.cs425.finalproject.senteapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = {"/","/senteapp"})
    public String displayHome(){
        return "index";
    }
}
