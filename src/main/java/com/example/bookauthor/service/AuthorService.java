package com.example.bookauthor.service;

import com.example.bookauthor.model.Author;
import java.util.List;

public interface AuthorService {

    List<Author> getAllAuthors();
    Author getAuthorById(Long id);
    Author createAuthor(String name);
    Author updateAuthor(Long id, String name);
}



