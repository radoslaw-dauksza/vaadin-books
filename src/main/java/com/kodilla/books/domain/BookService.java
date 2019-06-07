package com.kodilla.books.domain;

import com.kodilla.books.BookType;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public class BookService {
    private static BookService bookService;
    private Set<Book> books;

    private BookService() {
        this.books = exampleData();
    }

    public static BookService getInstance() {
        if (bookService == null) {
            bookService = new BookService();
        }
        return bookService;
    }

    public Set<Book> findByTitle(String title) {
        return books.stream().filter(book -> book.getTitle().contains(title)).collect(Collectors.toSet());
    }

    private Set<Book> exampleData() {
        Set<Book> books = new HashSet<>();
        books.add(new Book("Cracking the Coding Interview: 189 Programmieng Questions and Solutions", "Gayle Laakmann McDowell", "2015", BookType.IT));
        books.add(new Book("Introduction to Algorithms", "The MIT Press", "2019", BookType.IT));
        books.add(new Book("Introduction to the Theory of Computation", "Michael Sipser", "2012", BookType.IT));
        books.add(new Book("Operating System Concepts", "Silberschatz, Galvin, Gagne", "2012", BookType.IT));
        books.add(new Book("The Silent Patient", "Alex Michaelides", "2019", BookType.THRILLER));
        books.add(new Book("The Handmaid's Tale", "Margaret Atwood", "2019", BookType.CLASSIC));
        books.add(new Book("Watch Us Rise", "Renee Watson, Ellen Hagan", "2019", BookType.POETRY));
        return books;
    }

    public void save(Book book) {
        this.books.add(book);
    }

    public void delete(Book book) {
        this.books.remove(book);
    }
}
