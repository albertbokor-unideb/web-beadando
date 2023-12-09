package com.example.jws9ixbead.controller;

import com.example.jws9ixbead.model.Book;
import com.example.jws9ixbead.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    private BookRepo bookRepo;
    @GetMapping("/getBookAll")
    public ResponseEntity<List<Book>> getBookAll(){
        try{
            List<Book> bookList = new ArrayList<>();
            bookRepo.findAll().forEach(bookList::add);
            if(bookList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/getBookByISBN/{isbn}")
    public ResponseEntity<Book> getBookByISBN(@PathVariable Long isbn){
        Optional<Book> bookData =bookRepo.findById(isbn);
        if(bookData.isPresent()){
            return new ResponseEntity<>(bookData.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/addBook")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        Book bookObject = bookRepo.save(book);
        return new ResponseEntity<>(bookObject,HttpStatus.OK);
    }

    @PostMapping("/updateBookById")
    public ResponseEntity<Book> updateBookById(@PathVariable Long id, @RequestBody Book newData){
        Optional<Book> oldData =bookRepo.findById(id);
        if(oldData.isPresent()){
            Book updatedData = oldData.get();
            updatedData.setTitle(newData.getTitle());
            updatedData.setAuthor(newData.getAuthor());
            Book bookObj = bookRepo.save(updatedData);
            return new ResponseEntity<>(bookObj,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteBookById(@PathVariable Long id){
        bookRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
