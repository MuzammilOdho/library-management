package com.muzammil.dao.impl;

import com.muzammil.config.HibernateUtil;
import com.muzammil.dao.BookDAO;
import com.muzammil.model.Author;
import com.muzammil.model.Book;
import jakarta.persistence.RollbackException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class BookDaoImpl implements BookDAO {

    @Override
    public void saveBook(Book book) {
        Transaction tx = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(book);
            tx.commit();
        }catch (RollbackException e) {
            System.err.println("Rollback Exception" + e.getMessage());
            if (tx != null) tx.rollback();
        }catch (Exception e) {
            System.err.println("Exception" + e.getMessage());
        }
    }

    @Override
    public void deleteBook(Book book) {
        Transaction tx = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.remove(book);
            tx.commit();
        }catch (RollbackException e) {
            System.err.println("Rollback Exception" + e.getMessage());
            if (tx != null) tx.rollback();
        }catch (Exception e) {
            System.err.println("Exception" + e.getMessage());
        }
    }

    @Override
    public void updateBook(Book book) {
       Transaction tx = null;
       try(Session session = HibernateUtil.getSessionFactory().openSession()) {
           tx = session.beginTransaction();
           session.merge(book);
           tx.commit();
       }catch (RollbackException e) {
           System.err.println("Rollback Exception" + e.getMessage());
           if (tx != null) tx.rollback();
       }catch (Exception e) {
           System.err.println("Exception" + e.getMessage());
       }
    }

    @Override
    public List<Book> getBooks() {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Book", Book.class).getResultList();
        }catch (Exception e) {
            System.err.println("Exception" + e.getMessage());
        }
       return List.of();
    }

    @Override
    public Book getBookById(int id) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.find(Book.class, id);
        }catch (Exception e) {
            System.err.println("Exception" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Book> getBooksByAuthor(Author author) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("From Book  where author = :author", Book.class)
                    .setParameter("author", author).getResultList();
        }catch (Exception e) {
            System.err.println("Exception" + e.getMessage());
        }
        return List.of();
    }
}
