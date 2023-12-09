package com.example.jws9ixbead.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="Books")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Book {
    @Id
    @Column(name = "id", unique = true)
    private Long id;
    @Column(name = "TITLE")
    private String title;

    //@ManyToMany(cascade = CascadeType.ALL)
    @Column(name = "AUTHOR_ID")
    private String author;

}
