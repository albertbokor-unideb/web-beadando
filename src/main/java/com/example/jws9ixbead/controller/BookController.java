package com.example.jws9ixbead.controller;

import com.example.jws9ixbead.model.Book;
import com.example.jws9ixbead.repository.BookRepo;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookRepo bookRepo;
    @GetMapping
    public ResponseEntity<List<Book>> getBookAll(){
        
    }

    @GetMapping
    public void getBookByISBN(){

    }
    @PostMapping
    public void addBook(){

    }
    @PostMapping
    public void updateBookByISBN(){

    }
    @DeleteMapping
    public void deleteBookByISBN(){

    }



}
