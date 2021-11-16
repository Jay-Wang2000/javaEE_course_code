package com.example.demo.service;

import com.example.demo.bean.Account;
import com.example.demo.bean.ActionHistory;
import com.example.demo.bean.Book;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.ActionHistoryRepository;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class AdminService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    ActionHistoryRepository actionHistoryRepository;
    @Autowired
    AccountRepository accountRepository;

    private void actionHistory(String admin, String action) {     //保存操作历史
        ActionHistory actionHistory = new ActionHistory();
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyLocalizedPattern("yyyyMMddHHmmss");
        Date date = new Date();
        actionHistory.setTime(sdf.format(date));
        actionHistory.setAction(action);
        actionHistory.setName(admin);
        actionHistoryRepository.save(actionHistory);
    }

    @Transactional
    public Iterable<Account> getAllAccounts(String admin) {
        actionHistory(admin, "check_account_list");
        return accountRepository.findAll();
    }

    @Transactional
    public void addNewAccount(String admin, Account account) {
        accountRepository.save(account);
        actionHistory(admin, "add_an_account,username::" + account.getName());//保存操作历史
    }

    @Transactional
    public boolean password(String admin,int index,String password){
        if(!accountRepository.existsById(index))
            return false;
        Account account=accountRepository.findById(index).get();
        account.setPassword(password);
        accountRepository.save(account);
        actionHistory(admin," change account:"+String.valueOf(index)+"password to: "+password);
        return true;

    }

    @Transactional
    public boolean balance(String admin,int index,float balance){
        if(!accountRepository.existsById(index))
            return false;
        Account account=accountRepository.findById(index).get();
        account.setBalance(balance);
        accountRepository.save(account);
        actionHistory(admin," change account:"+String.valueOf(index)+"balance to: "+String.valueOf(balance));
        return true;
    }

    @Transactional
    public boolean deleteAccount(String admin, int index) {
        if (accountRepository.existsById(index)) {
            accountRepository.deleteById(index);
            actionHistory(admin, "delete_account:" + String.valueOf(index));
            return true;
        } else
            return false;
    }

    @Transactional
    public boolean repertory(String admin,int index,int repertory){
        if(!bookRepository.existsById(index))
            return false;
        Book book = bookRepository.findById(index).get();
        book.setRepertory(repertory);
        bookRepository.save(book);
        actionHistory(admin," change book:"+String.valueOf(index)+"repertory to: "+String.valueOf(repertory));
        return true;
    }

    @Transactional
    public boolean price(String admin,int index,float price){
        if(!bookRepository.existsById(index))
            return false;
        Book book = bookRepository.findById(index).get();
        book.setPrice(price);
        bookRepository.save(book);
        actionHistory(admin," change book:"+String.valueOf(index)+"price to: "+String.valueOf(price));
        return true;
    }

    @Transactional
    public void addNewBook(String admin, Book book) {
        bookRepository.save(book);

        actionHistory(admin, "add_a_book,book_name:" + book.getName());//保存操作历史
    }

    @Transactional
    public boolean deleteBook(String admin, int index) {
        if (bookRepository.existsById(index)) {
            bookRepository.deleteById(index);
            actionHistory(admin, "delete_book:" + String.valueOf(index));
            return true;
        } else
            return false;
    }

    public Iterable<Book> getAll(String admin) {
        actionHistory(admin, "check_the_book_list");
        return bookRepository.findAll();
    }

    public Iterable<ActionHistory> getAllActions(String admin) {
        actionHistory(admin, "check_the_action_history");
        return actionHistoryRepository.findAll();
    }
}
