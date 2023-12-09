package com.example.jws9ixbead.controller;

import com.example.jws9ixbead.model.Author;
import com.example.jws9ixbead.repository.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class AuthorController {
    @Autowired
    private AuthorRepo authorRepo;
    @GetMapping("/getAuthorAll")
    public ResponseEntity<List<Author>> getAuthorAll(){
        try{
            List<Author> authorList = new ArrayList<>();
            authorRepo.findAll().forEach(authorList::add);
            if(authorList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/getAuthorByISBN/{isbn}")
    public ResponseEntity<Author> getAuthorByISBN(@PathVariable Long id){
        Optional<Author> authorData = authorRepo.findById(id);
        if(authorData.isPresent()){
            return new ResponseEntity<>(authorData.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/addAuthor")
    public ResponseEntity<Author> addAuthor(@RequestBody Author author){
        Author authorObject = authorRepo.save(author);
        return new ResponseEntity<>(authorObject,HttpStatus.OK);
    }

    @PostMapping("/updateAuthorByISBN")
    public ResponseEntity<Author> updateAuthorByISBN(@PathVariable Long isbn, @RequestBody Author newData){
        Optional<Author> oldData = authorRepo.findById(isbn);
        if(oldData.isPresent()){
            Author updatedData = oldData.get();
            updatedData.setName(newData.getName());
            updatedData.setFamilyName(newData.getFamilyName());
            Author authorObj = authorRepo.save(updatedData);
            return new ResponseEntity<>(authorObj,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteAuthorByISBN(@PathVariable Long isbn){
        authorRepo.deleteById(isbn);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
