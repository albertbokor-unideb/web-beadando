package com.example.jws9ixbead.repository;

import com.example.jws9ixbead.model.Author;
import com.example.jws9ixbead.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Long> {
}
