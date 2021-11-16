package com.wang200.javaee_course_design.service;

import com.wang200.javaee_course_design.bean.Account;
import com.wang200.javaee_course_design.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AccountService {
    @Autowired private AccountRepository accountRepository;

    @Transactional
    public boolean check(String name,String password){
        if(accountRepository.existsById(name)){
            if(accountRepository.findById(name).get().getPassword().equals(password))
                return true;
        }
        else
            return false;
    }

    @Transactional
    public Account add(String name, String password, int identity){
        Account account=new Account();
        account.setName(name);
        account.setId(identity);
        account.setPassword(password);
        return accountRepository.save(account);
    }

    @Transactional
    public void delete(String name){
        accountRepository.deleteById(name);
    }

    public Account getByName(String name){
        return accountRepository.findById(name).get();
    }

    public Iterable<Account> getAll(){return accountRepository.findAll();}
}