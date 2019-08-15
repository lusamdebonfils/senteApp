package edu.mum.cs.cs425.finalproject.senteapp.controller;

import edu.mum.cs.cs425.finalproject.senteapp.model.*;
import edu.mum.cs.cs425.finalproject.senteapp.service.MemberService;
import edu.mum.cs.cs425.finalproject.senteapp.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PaymentController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private PaymentService paymentService;


    @GetMapping(value = "/senteapp/payment/deposit")
    public String displayPaymentForm(Model model){

        model.addAttribute("saving", new Saving());

        return "payment/deposit";
    }



    @RequestMapping(value = "/senteapp/payment/deposit", method = RequestMethod.POST)
    public String createNewSaving(@Valid @ModelAttribute("saving") Saving saving, BindingResult bindingResult, Model model, Principal principal){
        if(bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "payment/deposit";
        }
        //Setting Savings Details
        System.out.println("\n\n\n\n\n\n"+principal.getName());
        Member member = memberService.getMemberByEmail(principal.getName());
        System.out.println("\n\n\n\n\n\n"+member);
        System.out.println("\n\n\n\n\n\n"+member.getRecord());
        saving.setPaymentDate(LocalDate.now());
        member.getRecord().getSavingList().add(saving);
        System.out.println("\n\n\n\n\n\n\n"+saving);
        saving = paymentService.saveSaving(saving);
        System.out.println("\n\n\n\n\n\n\n"+saving);
        return "payment/apicall";
    }

}
