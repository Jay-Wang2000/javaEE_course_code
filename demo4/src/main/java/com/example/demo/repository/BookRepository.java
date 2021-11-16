package com.example.demo.repository;

import com.example.demo.bean.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {
}
