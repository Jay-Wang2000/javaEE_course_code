package com.example.demo.controller;

import com.example.demo.bean.Account;
import com.example.demo.bean.Book;
import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @RequestMapping("/deleteBook")
    public String delete(HttpServletRequest request, HttpSession session) {
        if (request.getParameter("index").isEmpty()) //输入错误
            return "hint/error_to_input";
        if (session.getAttribute("user") == null)//没有登录
            return "hint/error_to_log";
        if ((int) session.getAttribute("id") != 1)//不是管理员
            return "hint/error_id";
        if (adminService.deleteBook((String) session.getAttribute("user"),
                Integer.parseInt(request.getParameter("index")))) {
            request.setAttribute("books", adminService.getAll((String) session.getAttribute("user")));
            return "admin/books";
        } else
            return "hint/error_no_book";    //没有这本书
    }

    @Autowired
    AdminService adminService;

    @RequestMapping("/accounts")   //查看用户信息
    public String users(HttpSession session, HttpServletRequest request) {
        if (session.getAttribute("user") == null)  //没有登录
            return "hint/error_to_log";
        if ((int) session.getAttribute("id") != 1)      //不是管理员
            return "hint/error_id";
        Iterable<Account> accounts = adminService.getAllAccounts((String) session.getAttribute("user"));
        request.setAttribute("accounts", accounts);
        return "admin/accounts";
    }

    @RequestMapping("/password")
    public String password(HttpServletRequest request, HttpSession session) {
        if (request.getParameter("index").isEmpty()
        ||request.getParameter("password").isEmpty()) //输入错误
            return "hint/error_to_input";
        if (session.getAttribute("user") == null)//没有登录
            return "hint/error_to_log";
        if ((int) session.getAttribute("id") != 1)//不是管理员
            return "hint/error_id";
        if (adminService.password((String) session.getAttribute("user"), Integer.parseInt(request.getParameter("index")), request.getParameter("password"))){
            request.setAttribute("accounts", adminService.getAllAccounts((String) session.getAttribute("user")));
            return "admin/accounts";
        }
        return "hint/error_no_account";
    }

    @RequestMapping("/balance")
    public String balance(HttpServletRequest request, HttpSession session) {
        if (request.getParameter("index").isEmpty()
        ||request.getParameter("balance").isEmpty()) //输入错误
            return "hint/error_to_input";
        if (session.getAttribute("user") == null)//没有登录
            return "hint/error_to_log";
        if ((int) session.getAttribute("id") != 1)//不是管理员
            return "hint/error_id";
        if (adminService.balance((String) session.getAttribute("user"), Integer.parseInt(request.getParameter("index")), Float.parseFloat(request.getParameter("balance")))){
            request.setAttribute("accounts", adminService.getAllAccounts((String) session.getAttribute("user")));
            return "admin/accounts";
        }
        return "hint/error_no_account";
    }

    @RequestMapping("/addAccount")
    public String addAccount(HttpServletRequest request, HttpSession session) {
        String password = request.getParameter("password");
        String balance = request.getParameter("balance");
        String name = request.getParameter("name");
        if (password.isEmpty()
                || balance.isEmpty()) //输入错误
            return "hint/error_to_input";
        if (session.getAttribute("user") == null)  //没有登录
            return "hint/error_to_log";
        if ((int) session.getAttribute("id") != 1)  //不是管理员
            return "hint/error_id";
        if (Integer.parseInt(request.getParameter("balance")) < 0)   //输入不合法
            return "/hint/error_to_input";
        Account account = new Account();
        account.setId(0);
        account.setPassword(password);
        account.setName(name);
        account.setBalance(Float.parseFloat(balance));
        adminService.addNewAccount((String) session.getAttribute("user"), account);
        request.setAttribute("accounts", adminService.getAllAccounts((String) session.getAttribute("user")));
        return "admin/accounts";
    }

    @RequestMapping("/deleteAccount")
    public String deleteAccount(HttpServletRequest request, HttpSession session) {
        if (request.getParameter("index").isEmpty()) //输入错误
            return "hint/error_to_input";
        if (session.getAttribute("user") == null)//没有登录
            return "hint/error_to_log";
        if ((int) session.getAttribute("id") != 1)//不是管理员
            return "hint/error_id";
        if (adminService.deleteAccount((String) session.getAttribute("user"), Integer.parseInt(request.getParameter("index")))) {
            request.setAttribute("accounts", adminService.getAllAccounts((String) session.getAttribute("user")));
            return "admin/accounts";
        } else
            return "hint/error_no_Account";    //没有这个人
    }

    @RequestMapping("/books")   //查看书籍
    public String books(HttpSession session, HttpServletRequest request) {
        if (session.getAttribute("user") == null)  //没有登录
            return "hint/error_to_log";
        if ((int) session.getAttribute("id") != 1)      //不是管理员
            return "hint/error_id";
        request.setAttribute("books", adminService.getAll((String) session.getAttribute("user")));
        return "admin/books";               //没有这本书
    }

    @RequestMapping("/addBook")
    public String addBook(HttpServletRequest request, HttpSession session) {
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String repertory = request.getParameter("repertory");
        if (name.isEmpty()
                || price.isEmpty()
                || repertory.isEmpty()) //输入错误
            return "hint/error_to_input";
        if (session.getAttribute("user") == null)  //没有登录
            return "hint/error_to_log";
        if ((int) session.getAttribute("id") != 1)  //不是管理员
            return "hint/error_id";
        if (Integer.parseInt(repertory) < 0
                || Float.parseFloat(price) < 0)   //输入不合法
            return "/hint/error_to_input";
        Book book = new Book();
        book.setName(name);
        book.setPrice(Float.parseFloat(price));
        book.setRepertory(Integer.parseInt(repertory));
        adminService.addNewBook((String) session.getAttribute("user"), book);
        request.setAttribute("books", adminService.getAll((String) session.getAttribute("user")));
        return "admin/books";
    }

    @RequestMapping("/repertory")
    public String repertory(HttpServletRequest request, HttpSession session) {
        if (request.getParameter("index").isEmpty()
                ||request.getParameter("repertory").isEmpty()) //输入错误
            return "hint/error_to_input";
        if (session.getAttribute("user") == null)//没有登录
            return "hint/error_to_log";
        if ((int) session.getAttribute("id") != 1)//不是管理员
            return "hint/error_id";
        if (adminService.repertory((String) session.getAttribute("user"), Integer.parseInt(request.getParameter("index")), Integer.parseInt(request.getParameter("repertory")))) {
            request.setAttribute("books", adminService.getAll((String) session.getAttribute("user")));
            return "admin/books";
        }
        return "hint/error_no_book";

    }

    @RequestMapping("/price")
    public String price(HttpServletRequest request, HttpSession session) {
        if (request.getParameter("index").isEmpty()
                ||request.getParameter("price").isEmpty()) //输入错误
            return "hint/error_to_input";
        if (session.getAttribute("user") == null)//没有登录
            return "hint/error_to_log";
        if ((int) session.getAttribute("id") != 1)//不是管理员
            return "hint/error_id";
        if(adminService.price((String) session.getAttribute("user"),Integer.parseInt(request.getParameter("index")),Float.parseFloat(request.getParameter("price")))){
            request.setAttribute("books", adminService.getAll((String) session.getAttribute("user")));
            return "admin/books";
        }
        return "hint/error_no_book";
    }

    @RequestMapping("/actions")
    public String actions(HttpServletRequest request, HttpSession session) {
        if (session.getAttribute("user") == null)//没有登录
            return "hint/error_to_log";
        if ((int) session.getAttribute("id") != 1)//不是管理员
            return "hint/error_id";
        request.setAttribute("actions", adminService.getAllActions((String) session.getAttribute("user")));
        return "admin/actions";
    }
}
