package com.example.demo.service;

import com.example.demo.bean.Account;
import com.example.demo.bean.Book;
import com.example.demo.bean.CartItem;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.ShoppingCart;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomerService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    AccountRepository accountRepository;

    public boolean bookExist(int id) {
        if (bookRepository.existsById(id))
            return true;
        else
            return false;
    }

    public Book getBook(int id) {
        return bookRepository.findById(id).get();
    }

    public boolean check(int index, String password) {
        if (accountRepository.existsById(index)
                && accountRepository.findById(index).get().getPassword().equals(password))
            return true;
        return false;
    }

    public boolean shopping(int customer,ArrayList<CartItem> cartItems){
        Account account=accountRepository.findById(customer).get();
        float sum=0;
        for (CartItem cartItem:cartItems)
            sum+=cartItem.getSum();

        if(sum>account.getBalance())
            return false;
        for (CartItem cartItem:cartItems
        ) {
            int index=Integer.parseInt(cartItem.getId());
            Book book=bookRepository.findById(index).get();
            book.setRepertory(book.getRepertory()-cartItem.getQuantity());
            bookRepository.save(book);
        }
        account.setBalance(account.getBalance()-sum);
        accountRepository.save(account);
        return true;
    }
}
