package com.example.bookauthor.controller;

import com.example.bookauthor.model.Author;
import com.example.bookauthor.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public String listAuthors(Model model) {
        model.addAttribute("authors", authorService.getAllAuthors());
        return "authors";        // /WEB-INF/jsp/authors.jsp
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("author", new Author());
        return "author-form";    // /WEB-INF/jsp/author-form.jsp
    }

    @PostMapping("/save")
    public String saveAuthor(@ModelAttribute("author") Author author) {
        if (author.getId() == null) {
            authorService.createAuthor(author.getName());
        } else {
            authorService.updateAuthor(author.getId(), author.getName());
        }
        return "redirect:/authors";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Author author = authorService.getAuthorById(id);
        model.addAttribute("author", author);
        return "author-form";
    }
}



