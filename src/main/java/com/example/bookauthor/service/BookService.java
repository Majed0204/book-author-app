package com.example.bookauthor.service;

import com.example.bookauthor.model.Book;
import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    Book getBookById(Long id);
    Book createBook(String title, String isbn, Long authorId);
    Book updateBook(Long id, String title, String isbn, Long authorId);
    List<Book> findBooksByAuthorName(String name); // join query
}


