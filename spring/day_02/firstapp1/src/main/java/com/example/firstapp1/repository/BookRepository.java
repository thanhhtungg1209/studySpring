package com.example.firstapp1.repository;

import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.List;

@Repository
public class BookRepository {
    public List<Book> findAll(){
        return FakeDB.books;
    }

    public
}
