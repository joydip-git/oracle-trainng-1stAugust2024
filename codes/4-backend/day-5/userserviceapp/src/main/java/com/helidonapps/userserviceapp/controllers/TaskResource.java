package com.helidonapps.userserviceapp.controllers;

import com.helidonapps.userserviceapp.models.Task;
import com.helidonapps.userserviceapp.repository.RepositoryContract;

import jakarta.inject.Inject;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("taskapi")
public class TaskResource {

    @Inject
    private RepositoryContract<Task, Integer> repository;

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Task> fetchTasks() {
        try {
            List<Task> tasks = repository.getAll();
            if (tasks.isEmpty()) {
                throw new NotFoundException("no record");
            }
            return tasks;
        } catch (Exception e) {
            e.printStackTrace();
            throw new BadRequestException(e.getMessage());
        }
    }

    @GET
    @Path("get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Task fetchTask(@PathParam("id") int id) {
        Task task = repository.get(id);
        if (task == null) {
            throw new NotFoundException("no record found with id: " + id);
        }
        return task;
    }

    @POST
    @Path("add/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Task addTask(@PathParam("userId") int userId, Task task) {
        try {
            Task taskToAdd = new Task();
            taskToAdd.setUserId(userId);
            taskToAdd.setTitle(task.getTitle());
            taskToAdd.setCompleted(task.isCompleted());
            Task addedTask = repository.add(taskToAdd);
            return addedTask;
        } catch (Exception e) {
            throw new BadRequestException("unable to add user");
        }
    }

    @PUT
    @Path("update/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Task updateTask(@PathParam("id") int id, Task task) {
        try {
            Task updatedTask = repository.update(id, task);
            return updatedTask;
        } catch (Exception e) {
            throw new BadRequestException("unable to update user with id: " + id);
        }
    }

    @DELETE
    @Path("delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Task deleteTask(@PathParam("id") int id) {
        try {
            Task deletedTask = repository.delete(id);
            return deletedTask;
        } catch (Exception e) {
            throw new BadRequestException("unable to delete user with id: " + id);
        }
    }
}
