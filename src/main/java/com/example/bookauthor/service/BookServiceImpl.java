package com.example.bookauthor.service;

import com.example.bookauthor.model.Author;
import com.example.bookauthor.model.Book;
import com.example.bookauthor.repository.AuthorRepository;
import com.example.bookauthor.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository,
                           AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAllWithAuthors();
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }



    @Override
    public Book createBook(String title, String isbn, Long authorId) {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new RuntimeException("Author not found"));
        Book b = new Book();
        b.setTitle(title);
        b.setIsbn(isbn);
        b.setAuthor(author);
        return bookRepository.save(b);
    }

    @Override
    public Book updateBook(Long id, String title, String isbn, Long authorId) {
        Book existing = getBookById(id);
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new RuntimeException("Author not found"));
        existing.setTitle(title);
        existing.setIsbn(isbn);
        existing.setAuthor(author);
        return bookRepository.save(existing);
    }

    @Override
    public List<Book> findBooksByAuthorName(String name) {
        return bookRepository.findByAuthorNameLike(name);
    }
}


