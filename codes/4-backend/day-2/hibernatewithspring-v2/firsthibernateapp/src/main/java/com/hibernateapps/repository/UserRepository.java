package com.hibernateapps.repository;

import java.io.Serializable;
import java.util.List;

//import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.hibernateapps.models.User;

public class UserRepository implements RepositoryContract<User> {

    private HibernateTemplate template;

    public UserRepository(HibernateTemplate template) {
        this.template = template;
    }

    @Override
    public boolean add(User data) {
        try {
            Serializable savedData = template.save(data);
            return savedData != null;
        } catch (DataAccessException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public boolean update(int id, User data) {
        try {
            User currentUser = template.get(User.class, id);
            if (currentUser != null) {
                currentUser.setUserName(data.getUserName());
                template.update(currentUser);
                return true;
            } else
                return false;
        } catch (DataAccessException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public boolean delete(int id) {
        try {
            User currentUser = template.get(User.class, id);
            if (currentUser != null) {
                template.delete(currentUser);
                return true;
            } else
                return false;
        } catch (DataAccessException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<User> getAll() {
        try {
            return template.loadAll(User.class);
        } catch (DataAccessException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public User get(int id) {
        try {
            return template.get(User.class, id);
        } catch (DataAccessException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }
}
