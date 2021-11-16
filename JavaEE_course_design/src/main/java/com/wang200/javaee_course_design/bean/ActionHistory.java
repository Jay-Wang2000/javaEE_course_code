package com.wang200.javaee_course_design.bean;

import org.hibernate.Hibernate;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.Objects;

@Entity
@Table(name="ActionHistory")
public class ActionHistory {
    public static final long serialVersionId = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String time;

    //changeRepertory,addBook,check the list} ;
    private String action;

    private String name;

    public String getTime() {
        return time;
    }

    public String getAction() {
        return action;
    }

    public String getName() {
        return name;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setName(String name) {
        this.name = name;
    }
}
