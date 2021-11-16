package com.example.demo.bean;

import javax.persistence.*;

@Entity
@Table(name = "Account")
public class Account {
    public static final long serialVersionId = 4L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int inde;// 主键.

    private String name;

    private String password;

    private int id;     //id=0为普通用户 1为admin

    private float balance;

    public int getIndex() {
        return inde;
    }

    public float getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public void setIndex(int index) {
        this.inde = index;
    }

    public void setName(String id) {
        this.name = id;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }
}
