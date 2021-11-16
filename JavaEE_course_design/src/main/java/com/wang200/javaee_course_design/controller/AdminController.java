package com.wang200.javaee_course_design.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/shopping")
public class AdminController {

    @RequestMapping("/adminAccout")
    public ModelAndView adminAccout(){}

    @RequestMapping("/list")
    public ModelAndView list(){}

    @RequestMapping("/addBook")
    public ModelAndView addBook(){}

    @RequestMapping("/addRepertory")
    public ModelAndView addRepertoty(){}

    @RequestMapping("/decreaseRepertory")
    public ModelAndView decreaseRepertory(){}
}
