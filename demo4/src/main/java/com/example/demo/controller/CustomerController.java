package com.example.demo.controller;

import com.example.demo.bean.Book;
import com.example.demo.bean.CartItem;
import com.example.demo.repository.ShoppingCart;
import com.example.demo.service.AccountService;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    ShoppingCart shoppingCart = new ShoppingCart();

    @RequestMapping("/shoppingCart")
    public String shoppingCart(HttpSession session, HttpServletRequest request) {
        if (session.getAttribute("user") == null)  //未登录
            return "hint/error_to_log";
        request.setAttribute("sum", shoppingCart.getTotal());
        request.setAttribute("cart", shoppingCart.getCart());
        return "customer/shoppingCart";
    }

    @RequestMapping("/addBook")
    public String addBook(HttpSession session, HttpServletRequest request) {
        if (session.getAttribute("user") == null)  //未登录
            return "hint/error_to_log";
        String index = request.getParameter("index");
        String num = request.getParameter("num");
        if (index.isEmpty()
                || num.isEmpty()
                || !customerService.bookExist(Integer.parseInt(index))) //输入错误
            return "hint/error_to_input";
        Book book = customerService.getBook(Integer.parseInt(index));
        if (book.getRepertory() < Integer.parseInt(num))
            return "hint/error_to_repertory";
        shoppingCart.addCartItem(new CartItem(String.valueOf(book.getIndex()), book.getName(), Integer.parseInt(num), book.getPrice()));
        request.setAttribute("sum", shoppingCart.getTotal());
        request.setAttribute("cart",shoppingCart.getCart());
        return "customer/shoppingCart";
    }

    @RequestMapping("/delete")
    public String delete(HttpSession session, HttpServletRequest request) {
        if (session.getAttribute("user") == null)  //未登录
            return "hint/error_to_log";
        if (request.getParameter("index").isEmpty())
            return "hint/error_to_input";
        if (shoppingCart.removeCartItem(request.getParameter("index"))) {
            request.setAttribute("sum", shoppingCart.getTotal());
            request.setAttribute("cart", shoppingCart.getCart());
            return "customer/shoppingCart";
        }
        return "hint/error_no_book";
    }

    @RequestMapping("/settlement")
    public String settlement(HttpSession session, HttpServletRequest request) {
        if (session.getAttribute("user") == null)  //未登录
            return "hint/error_to_log";
        if ((int) session.getAttribute("settlement") == 1
                &&!shoppingCart.getCart().isEmpty()){       //访问控制，只能在有订单且购物车不为空的情况下结算
            request.setAttribute("sum", shoppingCart.getTotal());
            request.setAttribute("cart", shoppingCart.getCart());
            return "customer/pay";      //订单界面
        } else {
            request.setAttribute("noGoodinCart",1);
            return "/hint/error_to_pay";
        }
    }

    @RequestMapping("cancel_settlement")
    public String cancel_settlement(HttpSession session, HttpServletRequest request) {
        if (session.getAttribute("user") == null)  //未登录
            return "hint/error_to_log";
        session.setAttribute("settlement", 0);
        request.setAttribute("sum", shoppingCart.getTotal());
        request.setAttribute("cart", shoppingCart.getCart());
        return "customer/shoppingCart";
    }

    @RequestMapping("/confirm")
    public String confirm(HttpSession session, HttpServletRequest request) {
        if (session.getAttribute("user") == null)  //未登录
            return "hint/error_to_log";
        if (request.getParameter("index").isEmpty()
                || request.getParameter("password").isEmpty())
            return "hint/error_to_input";
        if ((int) session.getAttribute("confirm") == 1) {       //访问控制，页面只能由结算界面进入
            if (customerService.check(Integer.parseInt(request.getParameter("index"))
                    , request.getParameter("password"))) {  //登录成功
                if(!customerService.shopping(Integer.parseInt(request.getParameter("index")),shoppingCart.getCart()))
                    return "hint/error_to_balance"; //余额不足
                shoppingCart.removeAllCartItem();
                session.setAttribute("confirm",0);  //重设控制访问
                session.setAttribute("settlement",0);
                return "forward:/account";
            } else
                return "hint/error_to_input";
        }
        return "hint/error_to_visit";
    }
}
