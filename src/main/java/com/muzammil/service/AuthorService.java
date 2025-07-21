package com.muzammil.service;

import com.muzammil.dao.AuthorDAO;
import com.muzammil.dao.impl.AuthorDaoImpl;
import com.muzammil.model.Author;

import java.util.List;

public class AuthorService {
private  final  AuthorDAO authorDAO;

    public AuthorService() {
        this.authorDAO = new AuthorDaoImpl();
    }
    public void save(Author author) {

        authorDAO.saveAuthor(author);

    }

    public Author getAuthor(int id) {
        return authorDAO.getAuthorById(id);

    }

    public List<Author> getAllAuthors() {
        return authorDAO.getAuthors();
    }

    public void delete(Author author) {
        authorDAO.deleteAuthor(author);
    }
}
