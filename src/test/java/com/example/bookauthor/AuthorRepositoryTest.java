package com.example.bookauthor;

import com.example.bookauthor.model.Author;
import com.example.bookauthor.repository.AuthorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    void testSaveAuthor() {
        Author author = new Author();
        author.setName("Test Author");

        Author saved = authorRepository.save(author);

        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getName()).isEqualTo("Test Author");
    }
}
