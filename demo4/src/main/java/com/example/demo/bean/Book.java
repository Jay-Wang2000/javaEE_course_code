package com.example.demo.bean;

import javax.persistence.*;

@Entity
@Table(name = "Book")
public class Book {
    public static final long serialVersionId = 2L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int inde;// 主键.

    public int getIndex() {
        return inde;
    }

    public void setIndex(int index) {
        this.inde = index;
    }

    private String name;

    private float price;

    private int repertory;

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public int getRepertory() {
        return repertory;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setRepertory(int repertory) {
        this.repertory = repertory;
    }
}