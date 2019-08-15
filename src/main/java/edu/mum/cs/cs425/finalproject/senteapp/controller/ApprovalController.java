package edu.mum.cs.cs425.finalproject.senteapp.controller;

import edu.mum.cs.cs425.finalproject.senteapp.model.Account;
import edu.mum.cs.cs425.finalproject.senteapp.model.Member;
import edu.mum.cs.cs425.finalproject.senteapp.service.AccountService;
import edu.mum.cs.cs425.finalproject.senteapp.service.ApprovalService;
import edu.mum.cs.cs425.finalproject.senteapp.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class ApprovalController {

    @Autowired
    private ApprovalService approvalService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private AccountService accountService;
    @GetMapping(value = "senteapp/manager/approvals")
    public String getAllMembers(Principal principal, Model model){
        String email = principal.getName();
        Member member = memberService.getMemberByEmail(email);
        Account account = accountService.getAccountById(member.getMemberId());
        System.out.println("\n\n\n" + member.getAccount().getAccountId());
        model.addAttribute("approvals", approvalService.getAllApprovals(account));
        System.out.println(member);
        System.out.println( approvalService.getAllApprovals(account));
        return "manager/approvals";
    }
}
