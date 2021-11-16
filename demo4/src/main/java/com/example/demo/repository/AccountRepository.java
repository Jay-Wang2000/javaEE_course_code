package com.example.demo.repository;


import com.example.demo.bean.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Integer> {

}

