package com.hibernateapps;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernateapps.models.User;

public class App {
    public static void main(String[] args) {
        Configuration configuration = null;
        SessionFactory factory = null;
        Session session = null;
        Transaction transaction = null;

        try {
            // 1. load hibernate configuration file
            configuration = new Configuration();

            // 2. creating SessionFactory from loaded metadata
            factory = configuration.buildSessionFactory();
            // 3. creating a new Session
            session = factory.openSession();

            // 4. create persistence objects
            User anilUser = new User(1, "anil");
            User sunilUser = new User(2, "sunil");

            // 5. creating transaction for insertion
            transaction = session.beginTransaction();

            // 6. persisting the objects
            session.persist(anilUser);
            session.persist(sunilUser);

            // 7. fire the SQL query
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            // closing the session
            session.close();
        }
    }
}
