package com.muzammil.dao;

import com.muzammil.model.Author;

import java.util.List;

public interface AuthorDAO {
    void saveAuthor(Author author);
    void deleteAuthor(Author author);
    List<Author> getAuthors();
    Author getAuthorById(int id);
}
