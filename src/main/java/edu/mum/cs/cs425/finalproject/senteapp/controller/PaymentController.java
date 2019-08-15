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
        Member member = memberService.getMemberByEmail(principal.getName());
        saving.setPaymentDate(LocalDate.now());
        saving = paymentService.saveSaving(saving);
        saving.setVerifiedPayment(false);
        member.getRecord().getSavingList().add(saving);
        Double totalSavings = memberService.calculateMemberTotalSavings(member.getMemberId());
        member.getRecord().setTotalSaving(totalSavings);
        return "payment/apicall";
    }



    @GetMapping(value = "/senteapp/payment/payloan")
    public String displayLoanPaymentForm(Model model){

        model.addAttribute("installment", new Installment());

        return "payment/payloan";
    }



    @RequestMapping(value = "/senteapp/payment/payloan", method = RequestMethod.POST)
    public String createNewLoanDeposit(@Valid @ModelAttribute("installment") Installment installment, BindingResult bindingResult, Model model, Principal principal){
        if(bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "payment/payloan";
        }
        //Setting Savings Details
        Member member = memberService.getMemberByEmail(principal.getName());
        installment.setPaymentDate(LocalDate.now());
        installment = paymentService.saveInstallment(installment);
        paymentService.saveInstallment(installment);
       // member.getRecord().getSavingList().add(saving);
       // Double totalSavings = memberService.calculateMemberTotalSavings(member.getMemberId());
       // member.getRecord().setTotalSaving(totalSavings);
        return "payment/apicall";
    }


}
