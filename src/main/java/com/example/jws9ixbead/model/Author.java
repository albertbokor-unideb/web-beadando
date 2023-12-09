package com.example.jws9ixbead.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="Authors")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "Name")
    private String name;

    //@ManyToMany(cascade = CascadeType.ALL)
    @Column(name = "FamilyName")
    private String familyName;
}
