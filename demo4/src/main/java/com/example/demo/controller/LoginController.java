package com.example.demo.controller;


import com.example.demo.bean.Account;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    public static final String veri_code = "root";
    @Autowired
    private AccountService accountService;
    @Autowired
    private BookRepository bookRepository;

    @RequestMapping("/login")
    public String login() {
        return "sign_log/login";
    }

    @RequestMapping("/account")
    public String account(HttpServletRequest request, HttpSession session) {        //账户显示界面有三种进入情况：1、登陆后输网址进入 2、从登陆界面跳入 3、未登录
        if(session.getAttribute("user")!=null){// 说明已经登录
            request.setAttribute("balance",accountService.getByIndex((int) session.getAttribute("index")).getBalance());
            return "forward:/display";
        }
        if(session.getAttribute("user")==null&&request.getParameter("login")!=null) {    //说明从登陆界面跳入
            if (request.getParameter("index").isEmpty() || request.getParameter("password").isEmpty())
                return "hint/error_to_input";
            if (accountService.check(Integer.parseInt(request.getParameter("index")), request.getParameter("password"))) {
                Account account = accountService.getByIndex(Integer.parseInt(request.getParameter("index")));
                session.setAttribute("index",account.getIndex());
                session.setAttribute("user", account.getName());
                session.setAttribute("id", account.getId());
                request.setAttribute("balance",accountService.getByIndex((int) session.getAttribute("index")).getBalance());
                return "forward:/display";
            } else
                return "hint/error_to_input";
        }
        else//说明未登录
            return "hint/error_to_log";
    }

    @RequestMapping("/display") //根据id显示account
    public String display(HttpSession session) {
        if ((int) session.getAttribute("id") == 0)
            return "customer/accountview";
        else
            return "admin/admin_accountview";
    }

    @RequestMapping("/signin")
    public String signin() {
        return "sign_log/formal_signin";
    }

    @RequestMapping("/addAccount")
    public String addAccount(HttpServletRequest request) {
//        request.setAttribute("password","");
        if(request.getParameter("name").isEmpty()
        ||request.getParameter("password").isEmpty()
        ||request.getParameter("password'").isEmpty())  //没有输入
            return "hint/error_to_input";
        if (request.getParameter("password").equals(request.getParameter("password'"))) {
//            accountService.add(request.getParameter("user"), request.getParameter("password"), 0);
            Account account = new Account();
            account.setBalance(Float.parseFloat(request.getParameter("balance")));
            account.setId(Integer.parseInt(request.getParameter("id")));
            account.setName(request.getParameter("name"));
            account.setPassword(request.getParameter("password"));
            request.setAttribute("index", accountService.add(account).getIndex());
            return "hint/signin_success";
        } else return "hint/error_to_input";
    }

    @RequestMapping("/books")
    public String books(HttpServletRequest request) {
        request.setAttribute("books", bookRepository.findAll());
        return "books";
    }

    @RequestMapping("/si")
    public String si(){
        return "sign_log/sign_in";
    }
    @RequestMapping("/sign_in")
    public String sign_in(HttpServletRequest request, HttpSession session) {
        if(request.getParameter("veri")==null){      //若尝试输入网址进入
            return "hint/error_admin";
        }
        session.setAttribute("admin", 0);        //每次进入管理员注册界面时重置权限
        if (request.getParameter("veri_code").equals(veri_code)) {
            session.setAttribute("admin", 1);
            return "sign_log/adminSignin";
        } else
            return "hint/error_to_input";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        session.removeAttribute("id");
        session.removeAttribute("balance");
        return "/sign_log/login";
    }
}
