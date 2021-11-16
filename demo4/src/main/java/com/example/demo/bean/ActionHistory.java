package com.example.demo.bean;

import javax.persistence.*;

@Entity
@Table(name = "ActionHistory")
public class ActionHistory {
    public static final long serialVersionId = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int inde;// 主键.

    public int getIndex() {
        return inde;
    }

    public void setIndex(int index) {
        this.inde = index;
    }

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
