package oracle.springboot.apps.userservice.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import oracle.springboot.apps.userservice.models.User;

public interface UserRepositoryContract extends CrudRepository<User, Integer> {
    // List<User> filterUsersByName(String name);
}
