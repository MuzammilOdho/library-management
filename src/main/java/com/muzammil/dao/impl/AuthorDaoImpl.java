package com.muzammil.dao.impl;

import com.muzammil.config.HibernateUtil;
import com.muzammil.dao.AuthorDAO;
import com.muzammil.model.Author;
import jakarta.persistence.RollbackException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AuthorDaoImpl implements AuthorDAO {

    @Override
    public void saveAuthor(Author author) {
        Transaction tx = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
           tx = session.beginTransaction();
           session.persist(author);
           tx.commit();

        }catch (RollbackException e) {
            System.err.println("RollbackException" + e.getMessage());
            if (tx != null) tx.rollback();

        }catch (Exception e) {
            System.err.println("Exception" + e.getMessage());
        }
    }
    @Override
    public Author getAuthorById(int id) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {

            return session.find(Author.class,id);

        }catch (Exception e) {
            System.err.println("Exception" + e.getMessage());
        }
        return null;
    }

    @Override
    public void deleteAuthor(Author author) {
        Transaction tx = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.remove(author);
            tx.commit();
        }catch (RollbackException e) {
            System.err.println("RollbackException" + e.getMessage());
            if (tx != null) tx.rollback();

        }catch (Exception e) {
            System.err.println("Exception" + e.getMessage());
        }
    }


    @Override
    public List<Author> getAuthors() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("From Author", Author.class).getResultList();
        } catch (Exception e) {
            System.err.println("Exception" + e.getMessage());

        }
        return List.of();
    }


}
