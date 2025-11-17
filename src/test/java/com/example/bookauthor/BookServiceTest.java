package com.example.bookauthor;

import com.example.bookauthor.model.Author;
import com.example.bookauthor.model.Book;
import com.example.bookauthor.repository.AuthorRepository;
import com.example.bookauthor.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    void testCreateBook() {
        // use an author that already exists from data.sql
        Author author = authorRepository.findAll().get(0);

        Book created = bookService.createBook(
                "Test Book",
                "TST-001",
                author.getId()
        );

        assertNotNull(created.getId());
        assertEquals("Test Book", created.getTitle());
        assertEquals("TST-001", created.getIsbn());
        assertEquals(author.getId(), created.getAuthor().getId());
    }

    @Test
    void testGetAllBooks() {
        List<Book> books = bookService.getAllBooks();
        assertFalse(books.isEmpty());
    }

    @Test
    void testUpdateBook() {
        Author author = authorRepository.findAll().get(0);

        Book created = bookService.createBook(
                "Old Title",
                "OLD-001",
                author.getId()
        );

        Book updated = bookService.updateBook(
                created.getId(),
                "New Title",
                "NEW-001",
                author.getId()
        );

        assertEquals("New Title", updated.getTitle());
        assertEquals("NEW-001", updated.getIsbn());
    }
}


