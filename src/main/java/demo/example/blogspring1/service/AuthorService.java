package demo.example.blogspring1.service;

import demo.example.blogspring1.model.Author;

import java.util.List;

public interface AuthorService {
    Author create(Author author);
    Author findById(Long id);
    List<Author> findAll();
}
