package edu.mum.cs.cs425.finalproject.senteapp.controller;


import edu.mum.cs.cs425.finalproject.senteapp.model.*;
import edu.mum.cs.cs425.finalproject.senteapp.service.*;
import edu.mum.cs.cs425.finalproject.senteapp.service.implementation.SenteappUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
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
public class MemberController {

    private MemberService memberService;
    private AddressService addressService;
    @Autowired
    private SenteappUserDetailsService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private RecordService recordService;

    public MemberController(MemberService memberService, AddressService addressService){
        this.memberService = memberService;
        this.addressService = addressService;

    }


    @GetMapping(value = "senteapp/member/list")
    public String getAllMembers(@RequestParam(defaultValue = "0") Integer pageNo, Model model){
        model.addAttribute("members", memberService.getAllMembers(pageNo));
        model.addAttribute("allMemberCount", memberService.getAllMembers().size());
        model.addAttribute("currentPageNo", pageNo);
        return "member/list";
    }
    @GetMapping(value = "senteapp/member/membersperaccount")
    public String getAllMembersAccManager(@RequestParam(defaultValue = "0") Integer pageNo, Model model,Principal principal){
        String currentUser = principal.getName();
        //Member member = memberService
        model.addAttribute("members", memberService.getAllMembers(pageNo));
        model.addAttribute("allMemberCount", memberService.getAllMembers().size());
        model.addAttribute("currentPageNo", pageNo);
        return "member/membersperaccount";
    }

    @GetMapping(value = "/senteapp/account/memmberList/view{accountId}")
    public String getAllMembersPerAccount(@RequestParam(defaultValue = "0") Integer pageNo, Model model, Principal principal, @PathVariable Long accountId){
        //Member manager = memberService.
        Account account = accountService.getAccountById(accountId);
        System.out.println("Bishesshshshshhsh ::::: "+account);
        model.addAttribute("members", memberService.getAllByAccountID(accountId));
        model.addAttribute("allMemberCountAccount", memberService.getAllByAccountID(accountId).size());
        model.addAttribute("accountName", account.getAccountName());
        //model.addAttribute("members", memberService.getAllMembersPerAccount(account,pageNo));
        //model.addAttribute("currentPageNo", pageNo);
        return "member/membersperaccount";
    }

    @GetMapping(value = {"/senteapp/member/search"})
    public String searchMember(@RequestParam("search") String search,@RequestParam(defaultValue = "0") Integer pageNo, Model model) {
        model.addAttribute("members", memberService.searchMembers(search,pageNo));
        model.addAttribute("currentPageNo", pageNo);
        return "member/list";
    }


    @GetMapping(value = "/senteapp/member/addmanager")
    public String addNewManagerForm(Model model){
        model.addAttribute("address", new Address());
        model.addAttribute("member", new Member());
        model.addAttribute("accounts", accountService.getAllAccountsList());
        return "member/addmanager";
    }
    @PostMapping(value = "/senteapp/member/addmanager")
    public String createNewManager(@Valid @ModelAttribute("member") Member member, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "member/addmanager";
        }
        //Setting user details
        String defaultPassword = "$2a$10$pp418WOQMXjc3UFsbQQSkOATEwaKxIpiI6g.7vSOSYTTdd7G/xSIq";
        String userName = member.getFirstName().toLowerCase().charAt(0) + member.getLastName().toLowerCase()+ "@senteapp.com";
        //User user = member.getUser();
        List<Role> roles = new ArrayList<>();
        roles.add(roleService.getRoleById(2));



        User user = new User(userName,userName,defaultPassword,roles);
        user = userService.saveNewUser(user);
        member.setUser(user);
        member.setEmail(userName);
        member.setDateJoined(LocalDate.now());

        Record record = new Record();
        record = recordService.createRecord(record);
        System.out.println("\n\n\nuser details check : "+member.getUser());
        System.out.println("\n\n\nmember details check : "+member);
        member.setRecord(record);
        Member memberN = memberService.saveMember(member);
        System.out.println("\n\n\nmember details check : "+memberN);
        return"redirect:/senteapp/member/list";
    }




    @GetMapping(value = "/senteapp/member/add")
    public String addNewMemberForm(Model model){
        model.addAttribute("address", new Address());
        model.addAttribute("member", new Member());
        //model.addAttribute("roles", roleService.getAllRoles());
        return "member/add";
    }
    @PostMapping(value = "/senteapp/member/add")
    public String createNewMember(@Valid @ModelAttribute("member") Member member, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "member/add";
        }
        //Setting user details
        String defaultPassword = "$2a$10$pp418WOQMXjc3UFsbQQSkOATEwaKxIpiI6g.7vSOSYTTdd7G/xSIq";
        String userName = member.getFirstName().toLowerCase().charAt(0) + member.getLastName().toLowerCase()+ "@senteapp.com";
        //User user = member.getUser();
        List<Role> roles = new ArrayList<>();
        Record record = new Record();
        record = recordService.createRecord(record);
        System.out.println("\n\n\n" + record);
        roles.add(roleService.getRoleById(3));
        User user = new User(userName,userName,defaultPassword,roles);
        user = userService.saveNewUser(user);
        member.setUser(user);
        member.setRecord(record);
        member.setEmail(userName);
        member.setDateJoined(LocalDate.now());

        System.out.println("\n\n\nuser details check : "+member.getUser());
        System.out.println("\n\n\nmember details check : "+member);

        Member memberN = memberService.saveMember(member);
        System.out.println("\n\n\nmember details check : "+memberN);
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

    //public


}


