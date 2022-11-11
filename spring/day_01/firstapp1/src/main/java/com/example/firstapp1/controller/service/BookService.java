package com.example.firstapp1.controller.service;

import com.example.firstapp1.controller.model.Book;
import com.example.firstapp1.request.UpsertBookRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BookService {
    private List<Book> books;

    public BookService(){
        books = new ArrayList<>();
        books.add(new Book(1,"Book1","Des1",2022));
        books.add(new Book(2,"Book2","Des2",2020));
        books.add(new Book(3,"Book3","Des3",2010));
        books.add(new Book(4,"Book4","Des4",2009));


    }

    public List<Book> getBooks() {
        return books;
    }

    public Book getBookById( int id){
        for (Book book : books){
            if (book.getId() == id){
                return book;
            }
        }
        return null;
    }
    public Book createBook(UpsertBookRequest request){
        Random rd = new Random();
        int id = rd.nextInt(1000);
        Book book = new Book(id,request.getDescription(),request.getName(), request.getPublishYear());

        books.add(book);
        return book;
    }

    public Book updateBook(int id, UpsertBookRequest request){
        for (Book book : books){
            if (book.getId() == id){
                book.setDescription(request.getDescription());
                book.setName(request.getName());
                book.setPublishYear(request.getPublishYear());
                return book;
            }
        }
        return null;
    }
    public void deleteBook(int id){
        for (Book book : books){
            if (book.getId() == id){
                books.remove(book);
            }
        }

    }
}
