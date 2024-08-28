package com.hibernateapps.repository;

import java.util.List;

//import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernateapps.models.User;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

public class UserRepository implements RepositoryContract<User>, AutoCloseable {

    private SessionFactory factory;

    public UserRepository(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public boolean add(User data) {
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(data);
            transaction.commit();
            return true;
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        }
    }

    @Override
    public boolean update(int id, User data) {
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            User currentUser = session.get(User.class, id);
            if (currentUser != null) {
                currentUser.setUserName(data.getUserName());
                transaction.commit();
                return true;
            } else
                return false;
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        }
    }

    @Override
    public boolean delete(int id) {
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            User currentUser = session.get(User.class, id);
            if (currentUser != null) {
                session.remove(currentUser);
                transaction.commit();
                return true;
            } else
                return false;
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        }
    }

    @Override
    public List<User> getAll() {

        try (Session session = factory.openSession()) {
            // "select u from User u where u.id = 1"
            CriteriaBuilder builder = session
                    .getCriteriaBuilder();
            CriteriaQuery<User> query = builder.createQuery(User.class);
            query.from(User.class);
            return session.createQuery(query).getResultList();
        } catch (HibernateException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public User get(int id) {
        try (Session session = factory.openSession()) {
            return session.get(User.class, id);
        } catch (HibernateException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void close() throws Exception {
        if (factory != null)
            factory.close();
    }

}
