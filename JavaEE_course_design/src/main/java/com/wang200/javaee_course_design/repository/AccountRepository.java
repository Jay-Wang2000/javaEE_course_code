package com.wang200.javaee_course_design.repository;


import com.wang200.javaee_course_design.bean.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, String>{

}

