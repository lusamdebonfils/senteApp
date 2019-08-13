package edu.mum.cs.cs425.finalproject.senteapp.controller;

import edu.mum.cs.cs425.finalproject.senteapp.model.AccountType;
import edu.mum.cs.cs425.finalproject.senteapp.service.AccountTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class AccountTypeController {

    @Autowired
    private AccountTypeService accountTypeService;

    @GetMapping(value = "/senteapp/accounttype/list")
    public ModelAndView dispalyAccountTypes(@RequestParam(defaultValue = "0") Integer pageNo){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("accounttypes", accountTypeService.getAllAccountTypes(pageNo));
        modelAndView.addObject("currentPageNo", pageNo);
        modelAndView.setViewName("accounttype/list");
        return modelAndView;
    }


    @GetMapping(value = "/senteapp/accounttype/add")
    public String displayNewProductPage(Model model){
        model.addAttribute("accountType", new AccountType());
        return "accounttype/add";
    }

    @PostMapping(value = "/senteapp/accounttype/add")
    public String saveProduct(@Valid @ModelAttribute AccountType accountType, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "accounttype/add";
        }
        accountType = accountTypeService.addNewAccountType(accountType);
        return "redirect:/senteapp/accounttype/list";
    }

    @GetMapping(value = {"/senteapp/accounttype/edit{accountTypeId}"})
    public String editBook(@PathVariable Long accountTypeId, Model model) {
        System.out.println("\n\n\n\n\n\n" + accountTypeId +"\n\n\n\n");
        AccountType accountType = accountTypeService.getAccountTypeById(accountTypeId);
        if (accountType != null) {
            model.addAttribute("accountType", accountType);
            return "accounttype/edit";
        }
        return "accounttype/list";
    }

    @PostMapping(value = {"/senteapp/accounttype/edit"})
    public String updateBook(@Valid @ModelAttribute("accountType") AccountType accountType,
                             BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "accounttype/edit";
        }
        accountType = accountTypeService.addNewAccountType(accountType);
        return "redirect:/senteapp/accounttype/list";
    }
}
