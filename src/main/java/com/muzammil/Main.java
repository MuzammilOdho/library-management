package com.muzammil;

import com.muzammil.model.Author;
import com.muzammil.service.AuthorService;


public class Main {
    public static void main(String[] args) {
        AuthorService authorService = new AuthorService();
        Author author = new Author();
        author.setName("Muzammil");

        authorService.save(author);
    }
}