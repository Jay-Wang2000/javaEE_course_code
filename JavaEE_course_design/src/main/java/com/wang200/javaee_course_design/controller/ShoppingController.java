package com.wang200.javaee_course_design.controller;

import com.wang200.javaee_course_design.service.AccountService;
import com.wang200.javaee_course_design.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/shopping")
public class ShoppingController {
    @Autowired
    private AdminService adminService;
    private AccountService accountService;

    @RequestMapping("/account")
    public ModelAndView account(){}

    @RequestMapping("/orderHistory")
    public ModelAndView orderHistory(){}

    @RequestMapping("/shoppingCart")
    public ModelAndView shoppingCart(){}

    @RequestMapping("/addNum")
    public ModelAndView addNum(){}

    @RequestMapping("/reduceNum")
    public ModelAndView reduceNum(){}

    @RequestMapping("/confirm")
    public ModelAndView confirm(){}

    @RequestMapping("/password")
    public ModelAndView password(){}

    @RequestMapping("/books")
    public ModelAndView books(){}

    @RequestMapping("/detail")
    public ModelAndView detail(){}



    @RequestMapping("/action")
    public ModelAndView actionHistory(){}




}
