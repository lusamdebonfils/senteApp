package edu.mum.cs.cs425.finalproject.senteapp.controller;


import edu.mum.cs.cs425.finalproject.senteapp.model.Address;
import edu.mum.cs.cs425.finalproject.senteapp.model.Member;
import edu.mum.cs.cs425.finalproject.senteapp.service.AccountTypeService;
import edu.mum.cs.cs425.finalproject.senteapp.service.AddressService;
import edu.mum.cs.cs425.finalproject.senteapp.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class MemberController {

    private MemberService memberService;
    private AddressService addressService;

    public MemberController(MemberService memberService, AddressService addressService){
        this.memberService = memberService;
        this.addressService = addressService;
    }

    @GetMapping(value = "senteapp/member/list")
    public String getAllMembers(Model model){
        model.addAttribute("members", memberService.getAllMembers());

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

        System.out.println(member);
        System.out.println(member.getAddress().getAddressDetails());
       // address = addressService.saveAddress(address);

        return"redirect:/senteapp/member/list";
    }


}


