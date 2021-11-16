package com.wang200.javaee_course_design.bean;

import javax.persistence.*;

@Entity
@Table(name="BookList")
public class Book {
    public static final long serialVersionId = 2L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String name;

    private int price;

    private int repertory;

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getRepertory() {
        return repertory;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setRepertory(int repertory) {
        this.repertory = repertory;
    }
}
