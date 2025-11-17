package com.example.bookauthor.controller;

import com.example.bookauthor.model.Book;
import com.example.bookauthor.service.AuthorService;
import com.example.bookauthor.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;

    public BookController(BookService bookService,
                          AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping
    public String listBooks(@RequestParam(value = "authorName", required = false) String authorName,
                            Model model) {

        if (authorName != null && !authorName.isBlank()) {
            model.addAttribute("books", bookService.findBooksByAuthorName(authorName));
            model.addAttribute("authorName", authorName);
        } else {
            model.addAttribute("books", bookService.getAllBooks());
        }
        return "books"; // books.jsp
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("authors", authorService.getAllAuthors());
        return "book-form";
    }

    @PostMapping("/save")
    public String saveBook(@RequestParam Long authorId,
                           @ModelAttribute("book") Book book) {
        if (book.getId() == null) {
            bookService.createBook(book.getTitle(), book.getIsbn(), authorId);
        } else {
            bookService.updateBook(book.getId(), book.getTitle(), book.getIsbn(), authorId);
        }
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        model.addAttribute("authors", authorService.getAllAuthors());
        return "book-form";  // reuse same JSP
    }



}





