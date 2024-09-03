package com.helidonapps.databasedemo;

//import java.util.ArrayList;
import java.util.List;

import com.helidonapps.databasedemo.models.User;

//import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/user")
// @RequestScoped
// @Dependent
public class UserService {

    @PersistenceContext(name = "userPersistenceUnit")
    private EntityManager contexEntityManager;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    // @Transactional
    public List<User> getUsers() {
        // CriteriaQuery<User> query = contexEntityManager
        // .getCriteriaBuilder()
        // .createQuery(User.class);

        // query.from(User.class);
        // return contexEntityManager.createQuery(query).getResultList();
        return contexEntityManager.createNamedQuery("getAllUsers", User.class).getResultList();
    }
}
