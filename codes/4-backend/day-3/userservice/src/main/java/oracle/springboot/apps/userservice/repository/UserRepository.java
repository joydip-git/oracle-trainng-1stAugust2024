package oracle.springboot.apps.userservice.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import oracle.springboot.apps.userservice.models.User;

@Repository
public class UserRepository implements RepositoryContract<User> {

    private List<User> users;

    public UserRepository() {
        users = new ArrayList<>();
        users.add(new User(1, "anil"));
        users.add(new User(2, "sunil"));
    }

    @Override
    public boolean add(User data) {
        try {
            users.add(data);
            return true;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public boolean update(int id, User data) {
        try {
            List<User> foundList = users.stream().filter((u) -> u.getUserId() == id).toList();
            if (!foundList.isEmpty()) {
                User found = foundList.get(0);
                found.setUserName(data.getUserName());
                return true;
            } else
                return false;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public boolean delete(int id) {
        try {
            List<User> foundList = users.stream().filter((u) -> u.getUserId() == id).toList();
            if (!foundList.isEmpty()) {
                User found = foundList.get(0);
                users.remove(found);
                return true;
            } else
                return false;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<User> getAll() {
        try {
            return users;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public User get(int id) {
        try {
            List<User> foundList = users.stream().filter((u) -> u.getUserId() == id).toList();
            if (!foundList.isEmpty()) {
                User found = foundList.get(0);
                return found;
            } else
                return null;
        } catch (Exception e) {
            throw e;
        }
    }

}
