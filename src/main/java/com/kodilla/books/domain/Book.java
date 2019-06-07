package com.kodilla.books.domain;

import com.kodilla.books.BookType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book {
    private String title;
    private String author;
    private String publicationYear;
    private BookType type;
}
