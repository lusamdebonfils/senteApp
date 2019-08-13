package edu.mum.cs.cs425.finalproject.senteapp.controller;

import edu.mum.cs.cs425.finalproject.senteapp.model.Account;
import edu.mum.cs.cs425.finalproject.senteapp.service.AccountService;
import edu.mum.cs.cs425.finalproject.senteapp.service.AccountTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class AccountController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountTypeService accountTypeService;

    @GetMapping(value = "/senteapp/account/list")
    public ModelAndView displayAccounts(@RequestParam(defaultValue = "0") Integer pageNo){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("accounts", accountService.getAllAccounts(pageNo));
        modelAndView.addObject("currentPageNo", pageNo);
        modelAndView.setViewName("account/list");
        return modelAndView;
    }

    @GetMapping(value = {"/senteapp/account/new"})
    public String displayNewAccountForm(Model model) {
        model.addAttribute("account", new Account());
        model.addAttribute("accounttypes", accountTypeService.getAllAccountTypesList());
        return "account/new";
    }

    @PostMapping(value = {"/senteapp/account/new"})
    public String addNewAccount(@Valid @ModelAttribute("account") Account account,
                             BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "account/new";
        }
        accountService.saveAccount(account);
        return "redirect:/senteapp/account/list";
    }

    @GetMapping(value = {"/senteapp/account/edit{accountId}"})
    public String editAccount(@PathVariable Long accountId, Model model) {

        Account account = accountService.getAccountById(accountId);
        if (account != null) {
            model.addAttribute("account", account);
            model.addAttribute("accounttypes", accountTypeService.getAllAccountTypesList());
            return "account/edit";
        }
        return "account/list";
    }

    @PostMapping(value = {"/senteapp/account/edit"})
    public String updateAccount(@Valid @ModelAttribute("account") Account account,
                             BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "account/edit";
        }
        accountService.saveAccount(account);
        return "redirect:/senteapp/account/list";
    }


}
