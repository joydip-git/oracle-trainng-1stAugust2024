package com.helidonapps.userserviceapp.repository;

import java.util.List;

import org.jboss.logging.processor.util.Objects;

import com.helidonapps.userserviceapp.models.Task;
import com.helidonapps.userserviceapp.models.User;

import jakarta.enterprise.context.Dependent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Dependent
public class TaskRepository implements RepositoryContract<Task, Integer> {

    @PersistenceContext(name = "UserPersistenceContext")
    private EntityManager manager;

    @Override
    public List<Task> getAll() {
        try {
            return manager.createNamedQuery("getAllTask", Task.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Task get(Integer id) {
        try {
            TypedQuery<Task> query = manager.createNamedQuery("getTaskById", Task.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Task add(Task data) {
        try {
            int userId = data.getUserId();
            User user = manager.find(User.class, userId);
            if (user != null) {
                user.getTasks().add(new Task(0, data.getTitle(), data.isCompleted()));
                data.setUser(user);
                manager.persist(data);
                return data;
            } else
                return null;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Task update(Integer id, Task data) {
        try {
            Task task = manager.find(Task.class, id);
            if (task != null) {
                manager.merge(task);
                return task;
            } else
                return null;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Task delete(Integer id) {
        try {
            Task task = manager.find(Task.class, id);
            manager.remove(task);
            return task;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

}
