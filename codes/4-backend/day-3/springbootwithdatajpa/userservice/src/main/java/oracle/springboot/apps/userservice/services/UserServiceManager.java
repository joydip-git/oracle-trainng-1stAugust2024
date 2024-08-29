package oracle.springboot.apps.userservice.services;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oracle.springboot.apps.userservice.models.User;
import oracle.springboot.apps.userservice.repository.UserRepositoryContract;

@Service
public class UserServiceManager implements ServiceContract<User, Integer> {

    @Autowired
    private UserRepositoryContract repository;

    @Override
    public User add(User data) {
        return repository.save(data);
    }

    @Override
    public User update(Integer id, User data) {
        User found = repository.findById(id).get();
        if (Objects.nonNull(found.getUserName()) && !"".equalsIgnoreCase(found.getUserName())) {
            found.setUserName(data.getUserName());
        }
        return repository.save(found);
    }

    @Override
    public boolean delete(Integer id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public List<User> getAll() {
        return ((List<User>) repository.findAll())
                .stream()
                .sorted((u1, u2) -> u1.getUserId() - u2.getUserId())
                .toList();
    }

    @Override
    public User get(Integer id) {
        return repository.findById(id).get();
    }

}
