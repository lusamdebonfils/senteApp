package edu.mum.cs.cs425.finalproject.senteapp.controller;

import edu.mum.cs.cs425.finalproject.senteapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping(value = "/senteapp/account/list")
    public ModelAndView displayAccounts(@RequestParam(defaultValue = "0") Integer pageNo){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("accounts", accountService.getAllAccounts(pageNo));
        modelAndView.addObject("currentPageNo", pageNo);
        modelAndView.setViewName("account/list");
        return modelAndView;
    }

}
