package com.wang200.javaee_course_design.service;

import com.wang200.javaee_course_design.bean.ActionHistory;
import com.wang200.javaee_course_design.bean.Book;
import com.wang200.javaee_course_design.repository.ActionHistoryRepository;
import com.wang200.javaee_course_design.repository.BookRepository;
import com.wang200.javaee_course_design.repository.OrderHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class AdminService {
    @Autowired
    BookRepository bookRepository;
    ActionHistoryRepository actionHistoryRepository;

    @Transactional
    public void addNew(String admin,String name,int price,int repertory){
        Book book=new Book();
        book.setName(name);
        book.setPrice(price);
        book.setRepertory(repertory);
        bookRepository.save(book);

        ActionHistory actionHistory=new ActionHistory();
        SimpleDateFormat sdf=new SimpleDateFormat();
        sdf.applyLocalizedPattern("yyyyMMddHHmmss");
        Date date=new Date();
        actionHistory.setTime(sdf.format(date));
        actionHistory.setAction("add_a_book:"+name);
        actionHistory.setName(admin);
        actionHistoryRepository.save(actionHistory);
    }
    @Transactional
    public boolean changeNum(String admin,String name,int repertory){
        if(bookRepository.existsById(name)) {
            Book bbook =bookRepository.findById(name).get();
            Book book = new Book();
            book.setName(bbook.getName());
            book.setPrice(bbook.getPrice());
            book.setRepertory(repertory);
            bookRepository.deleteById(name);
            bookRepository.save(book);

            ActionHistory actionHistory=new ActionHistory();
            SimpleDateFormat sdf=new SimpleDateFormat();
            sdf.applyLocalizedPattern("yyyyMMddHHmmss");
            Date date=new Date();
            actionHistory.setTime(sdf.format(date));
            actionHistory.setAction("change_the_repertory_of"+name+"to"+repertory);
            actionHistory.setName(admin);
            actionHistoryRepository.save(actionHistory);
            return true;
        }else
            return false;
    }
    public Iterable<Book> getAll(String admin) {
        ActionHistory actionHistory=new ActionHistory();
        SimpleDateFormat sdf=new SimpleDateFormat();
        sdf.applyLocalizedPattern("yyyyMMddHHmmss");
        Date date=new Date();
        actionHistory.setTime(sdf.format(date));
        actionHistory.setAction("check_the_book_list");
        actionHistory.setName(admin);
        actionHistoryRepository.save(actionHistory);

        return bookRepository.findAll();}

}
