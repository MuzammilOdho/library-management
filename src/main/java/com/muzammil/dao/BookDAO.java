package com.muzammil.dao;

import com.muzammil.model.Author;
import com.muzammil.model.Book;

import java.util.List;

public interface BookDAO {
    void saveBook(Book book);
    void deleteBook(Book book);
    void updateBook(Book book);
    List<Book> getBooks();
    Book getBookById(int id);
    List<Book> getBooksByAuthor(Author author);

}
