package com.example.firstapp1.controller;

import com.example.firstapp1.controller.model.Book;
import com.example.firstapp1.controller.service.BookService;
import com.example.firstapp1.request.UpsertBookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/books")
public class BookController {
    @Autowired // inject bean
    private BookService bookService;



    // Get: api/v1/books : lay danh sach tat ca book
    @GetMapping("")
        public List<Book> getBook(){
        return bookService.getBooks();
        }


    // Post: api/v1/books : tao moi book
    @PostMapping("")
    public Book createBook(@RequestBody UpsertBookRequest request){

        return bookService.createBook(request);
    }


    // Get: api/v1/books{id} : lay chi tiet mot cuon sach
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id){
        return bookService.getBookById(id);
    }

    // Put: api/v1/books{id} : cap nhat thong tin cuon sach
    @PutMapping("/{id} ")
    public Book updateBook(@PathVariable int id,@RequestBody UpsertBookRequest request ){
        return bookService.updateBook(id, request);
    }

    // Delete : api/v1/books{id} : xoa cuon sach theo id
    @DeleteMapping("/{id}")
    public  void  deleteBook(@PathVariable int id){
        bookService.deleteBook(id);

    }



}
