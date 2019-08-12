package edu.mum.cs.cs425.finalproject.senteapp.controller;

import edu.mum.cs.cs425.finalproject.senteapp.service.AccountTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccountTypeController {

    @Autowired
    private AccountTypeService accountTypeService;

    @GetMapping(value = "/senteapp/accounttype/new")
    public ModelAndView dispalyAllProducts(@RequestParam(defaultValue = "0") Integer pageno){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("currentPageNo", pageno);
        modelAndView.setViewName("accounttype/new");
        return modelAndView;
    }


    @GetMapping(value = "/senteapp/accounttype/list")
    public ModelAndView dispalyAccountTypes(@RequestParam(defaultValue = "0") Integer pageNo){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("accounttypes", accountTypeService.getAllAccountTypes(pageNo));
        modelAndView.addObject("currentPageNo", pageNo);
        modelAndView.setViewName("accounttype/list");
        return modelAndView;
    }

}
