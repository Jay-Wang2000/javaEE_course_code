package com.wang200.javaee_course_design.bean;

import javax.persistence.*;

@Entity
@Table(name="Account")
public class Account {
    public static final long serialVersionId = 4L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String name;

    private String password;

    private int id;

    private int balance;

    public int getBalance() {return balance;}

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {return id;}

    public void setName(String id) {this.name = id;}

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(int id) {
        this.id =id;
    }
}
