package com.wang200.javaee_course_design.repository;

import com.wang200.javaee_course_design.bean.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, String>{
}
