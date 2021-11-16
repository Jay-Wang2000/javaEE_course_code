package com.example.demo.service;


import com.example.demo.bean.Account;
import com.example.demo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public boolean check(int index, String password) {
        if (accountRepository.existsById(index) && accountRepository.findById(index).get().getPassword().equals(password)) {
            return true;
        } else
            return false;
    }

    @Transactional
    public Account add(Account account) {
        return accountRepository.save(account);
    }

    public Account getByIndex(int index) {
        return accountRepository.findById(index).get();
    }
}