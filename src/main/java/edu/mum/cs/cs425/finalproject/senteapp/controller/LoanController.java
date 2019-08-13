package edu.mum.cs.cs425.finalproject.senteapp.controller;

import edu.mum.cs.cs425.finalproject.senteapp.model.AccountType;
import edu.mum.cs.cs425.finalproject.senteapp.model.Loan;
import edu.mum.cs.cs425.finalproject.senteapp.model.Member;
import edu.mum.cs.cs425.finalproject.senteapp.service.LoanService;
import edu.mum.cs.cs425.finalproject.senteapp.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.stereotype.Controller;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LoanController {
    @Autowired
    private MemberService memberService;

    @Autowired
    private LoanService loanService;

    @GetMapping(value = "/senteapp/loan/apply")
    public String displayNewProductPage(Model model){
        model.addAttribute("loan", new Loan());
        model.addAttribute("members", memberService.getAllMembers());
        return "loan/apply";
    }

    @PostMapping(value = "/senteapp/loan/apply")
    public String saveProduct(@Valid @ModelAttribute Loan loan, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "loan/apply";
        }
        List<Member> members = new ArrayList<>();
       // members.add()
        loan.setApplicationDate(LocalDate.now());
        loan = loanService.saveLoanRecord(loan);
        System.out.println("\n\n\n" + loan + "\n\n\n");
        return "redirect:/senteapp/accounttype/list";
    }


