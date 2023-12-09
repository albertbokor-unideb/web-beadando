package com.example.jws9ixbead.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

public class BookDto {
    private Long isbn;
    private String title;
    private String author;

}
