package com.helidonapps.userserviceapp.repository;

import java.util.List;

import com.helidonapps.userserviceapp.models.User;

import jakarta.enterprise.context.Dependent;
//import jakarta.enterprise.context.Dependent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Dependent
public class UserRepository implements RepositoryContract<User, Integer> {

    @PersistenceContext(unitName = "UserPersistenceContext")
    EntityManager manager;

    @Override
    public List<User> getAll() {
        /*
         * CriteriaQuery<User> query = manager
         * .getCriteriaBuilder()
         * .createQuery(User.class);
         * query.from(User.class);
         * return manager.createQuery(query).getResultList();
         */
        try {
            return manager.createNamedQuery("getAllUser", User.class).getResultList();
        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public User get(Integer id) {
        try {
            TypedQuery<User> query = manager
                    .createNamedQuery("getAnUser", User.class);
            query.setParameter("userId", id);
            return query.getSingleResult();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    // @Transactional(Transactional.TxType.REQUIRED)
    @Transactional(value = TxType.REQUIRED)
    public User add(User data) {
        try {
            manager.persist(data);
            return data;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    @Transactional(value = TxType.REQUIRED)
    public User update(Integer id, User data) {
        try {
            User user = manager.find(User.class, id);
            if (user != null) {
                user.setUserName(data.getUserName());
                return manager.merge(user);
            } else
                return null;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    @Transactional(value = TxType.REQUIRED)
    public User delete(Integer id) {
        try {
            User user = manager.find(User.class, id);
            manager.remove(user);
            return user;
        } catch (Exception e) {
            throw e;
        }
    }
}
