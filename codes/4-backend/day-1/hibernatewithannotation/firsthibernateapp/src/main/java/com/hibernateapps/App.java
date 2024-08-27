package com.hibernateapps;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.cfg.Configuration;

import com.hibernateapps.models.User;

public class App {
    public static void main(String[] args) {
        // Configuration configuration = null;
        SessionFactory factory = null;
        Session session = null;
        Transaction transaction = null;

        StandardServiceRegistry registry = null;
        MetadataSources sources = null;
        Metadata dbMetadata = null;

        try {
            // 1.a. load hibernate configuration file and building a registry for the
            // service
            // object that supplies the file to MetadataSources
            registry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();

            // 1.b. Loading metadata from registry
            sources = new MetadataSources(registry);

            // 1.c. creating metadata object for session factory
            dbMetadata = sources.buildMetadata();

            // 2. creating SessionFactory from loaded metadata
            factory = dbMetadata.buildSessionFactory();

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
