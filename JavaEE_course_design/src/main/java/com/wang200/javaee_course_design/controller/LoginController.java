package com.wang200.javaee_course_design.controller;

import com.wang200.javaee_course_design.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/shopping")
public class LoginController {

    public static final String veri_code="root";
    @Autowired
    private AccountService accountService;

    @RequestMapping("/login")
    public String login(HttpServletRequest request){
        if(accountService.check(request.getParameter("user"),request.getParameter("password"))){
            request.getSession().setAttribute("user",request.getParameter("user"));
        }
        return "/WEB-INF/login.jsp";
    }

    @RequestMapping("/signin")
    public String signin(){
        return "formal_signin";
    }

    @RequestMapping("/addAccount")
    public String addAccount(HttpServletRequest request){
//        request.setAttribute("password","");
        if(request.getParameter("password").equals(request.getParameter("password'"))){
            accountService.add(request.getParameter("user"), request.getParameter("password"), 0);
            return "/WEB-INF/login.jsp";
        }
        else return "error";
    }

    @RequestMapping("/sign_in")
    public String sign_in(HttpServletRequest request){
        HttpSession session=request.getSession();
        session.setAttribute("admin",0);
        if(request.getParameter("veri_code").equals(veri_code)){
            session.setAttribute("admin",1);
            return "adminSignin";
        }
        else
            return "error";
    }
}
