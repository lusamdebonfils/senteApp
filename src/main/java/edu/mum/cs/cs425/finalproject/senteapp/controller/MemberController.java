package edu.mum.cs.cs425.finalproject.senteapp.controller;


import edu.mum.cs.cs425.finalproject.senteapp.model.Account;
import edu.mum.cs.cs425.finalproject.senteapp.model.Address;
import edu.mum.cs.cs425.finalproject.senteapp.model.Member;
import edu.mum.cs.cs425.finalproject.senteapp.service.AccountTypeService;
import edu.mum.cs.cs425.finalproject.senteapp.service.AddressService;
import edu.mum.cs.cs425.finalproject.senteapp.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MemberController {

    private MemberService memberService;
    private AddressService addressService;

    public MemberController(MemberService memberService, AddressService addressService){
        this.memberService = memberService;
        this.addressService = addressService;
    }


    @GetMapping(value = "senteapp/member/list")
    public String getAllMembers(@RequestParam(defaultValue = "0") Integer pageNo, Model model){
        model.addAttribute("members", memberService.getAllMembers(pageNo));
        model.addAttribute("currentPageNo", pageNo);
        return "member/list";
    }
    @GetMapping(value = {"/senteapp/member/search"})
    public String searchMember(@RequestParam("search") String search,@RequestParam(defaultValue = "0") Integer pageNo, Model model) {
        model.addAttribute("members", memberService.searchMembers(search,pageNo));
        model.addAttribute("currentPageNo", pageNo);
        return "member/list";
    }
    @GetMapping(value = "/senteapp/member/add")
    public String addNewMemberForm(Model model){
        model.addAttribute("address", new Address());
        model.addAttribute("member", new Member());
        return "member/add";
    }
    @PostMapping(value = "/senteapp/member/add")
    public String createNewMember(@Valid @ModelAttribute("member") Member member, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "member/add";
        }
        member = memberService.saveMember(member);
        return"redirect:/senteapp/member/list";
    }

    @GetMapping(value = {"/senteapp/member/edit{memberId}"})
    public String editAccount(@PathVariable Long memberId, Model model) {
        Member member = memberService.getMemberById(memberId);

        if (member != null) {
            model.addAttribute("member", member);

            return "member/edit";
        }
        return "member/list";
    }

    @PostMapping(value = {"/senteapp/member/edit"})
    public String updateAccount(@Valid @ModelAttribute("member") Member member,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "member/edit";
        }
        memberService.saveMember(member);
        return "redirect:/senteapp/member/list";
    }


}


