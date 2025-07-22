package com.muzammil.service;

import com.muzammil.dao.BookDAO;
import com.muzammil.dao.impl.BookDaoImpl;
import com.muzammil.model.Author;
import com.muzammil.model.Book;

import java.util.List;

public class BookService {
    private BookDAO bookDAO;

    public BookService() {
        this.bookDAO = new BookDaoImpl();
    }
    public  void saveBook(Book book) {
        bookDAO.saveBook(book);
    }
    public List<Book> getBooks() {
        return bookDAO.getBooks();
    }
    public Book getBook(int id) {
        return bookDAO.getBookById(id);
    }
    public List<Book> getBooksByAuthor(Author author) {
        return bookDAO.getBooksByAuthor(author);

    }
    public void deleteBook(int id) {
        bookDAO.deleteBook(bookDAO.getBookById(id));
    }
    public void updateBook(Book book) {
        bookDAO.updateBook(book);
    }

}
