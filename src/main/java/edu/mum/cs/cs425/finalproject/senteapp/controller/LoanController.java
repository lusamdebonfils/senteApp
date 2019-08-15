package edu.mum.cs.cs425.finalproject.senteapp.controller;

import edu.mum.cs.cs425.finalproject.senteapp.model.*;
import edu.mum.cs.cs425.finalproject.senteapp.service.ApprovalService;
import edu.mum.cs.cs425.finalproject.senteapp.service.LoanService;
import edu.mum.cs.cs425.finalproject.senteapp.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDate;
import java.util.*;

@Controller
public class LoanController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private LoanService loanService;

    @Autowired
    private ApprovalService approvalService;


    @RequestMapping(value = "/senteapp/loan/apply", method = RequestMethod.GET)
    public String displayNewProductPage(Model model, Principal principal) {
        model.addAttribute("loan", new Loan());

        String email = principal.getName();
        Member member = memberService.getMemberByEmail(email);
        Account account = member.getAccount();
        List<Member> members = memberService.getMembersByAccount(account);
        members.remove(member);
        model.addAttribute("members", members);
        return "loan/apply";
    }

    @RequestMapping(value = "/senteapp/loan/apply", method = RequestMethod.POST)
    public String saveProduct(@Valid @ModelAttribute Loan loan, BindingResult bindingResult, Model model,Principal principal) {
        System.out.println("\n\n\n\n" + loan);
        String email = principal.getName();
        System.out.println("\n\n\n\n" + email);
        Member member = memberService.getMemberByEmail(email);
        System.out.println("\n\n\n\n" + member);
        Account account = member.getAccount();

        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "loan/apply";
        }

        // Checking if seconders are Unique
        Set<String> loanApps = new HashSet<String>();
        loanApps.add(principal.getName());
        loanApps.add(loan.getFirstSeconder().getEmail());
        loanApps.add(loan.getSecondSeconder().getEmail());
        if(loanApps.size() != 3){
            return "loan/sureties";
        }

        //checking if your eligible for loan

        if((memberService.calculateMemberAccountBalance(member.getMemberId()) +
                memberService.calculateMemberAccountBalance(loan.getFirstSeconder().getMemberId()) +
                memberService.calculateMemberAccountBalance(loan.getSecondSeconder().getMemberId()))<loan.getLoanAmount()){
            return "loan/unsuccessful";
        }

        loan.setApplicationDate(LocalDate.now());
        loan.setLoanNumber(UUID.randomUUID().toString());
        loan.setApplicant(member);
        loan = loanService.saveLoanRecord(loan);
        System.out.println("\n\n\n" + loan + "\n\n\n");
        Approval approval = new Approval();
        approval.setLoan(loan);
        approval.setAccount(account);
        approvalService.saveApproval(approval);
        return "loan/successful";
    }

}
