package com.helidonapps.userserviceapp.controllers;

import java.util.List;

import com.helidonapps.userserviceapp.models.User;
import com.helidonapps.userserviceapp.repository.RepositoryContract;

import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.Produces;

@Path(value = "userapi")
@Dependent
public class UserResource {

    @Inject
    private RepositoryContract<User, Integer> repository;

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> fetchUsers() {

        List<User> users = repository.getAll();
        if (users.isEmpty()) {
            throw new NotFoundException("no record");
        }
        return users;
    }

    @GET
    @Path("get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User fetchUser(@PathParam("id") int id) {
        User user = repository.get(id);
        if (user == null) {
            throw new NotFoundException("no record found with id: " + id);
        }
        return user;
    }

    @POST
    @Path("add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public User addUser(User user) {
        try {
            User addedUser = repository.add(user);
            return addedUser;
        } catch (Exception e) {
            throw new BadRequestException("unable to add user");
        }
    }

    @PUT
    @Path("update/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public User updateUser(@PathParam("id") int id, User user) {
        try {
            User updatedUser = repository.update(id, user);
            return updatedUser;
        } catch (Exception e) {
            throw new BadRequestException("unable to update user with id: " + id);
        }
    }

    @DELETE
    @Path("delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User deleteUser(@PathParam("id") int id) {
        try {
            User deletedUser = repository.delete(id);
            return deletedUser;
        } catch (Exception e) {
            throw new BadRequestException("unable to delete user with id: " + id);
        }
    }
}
