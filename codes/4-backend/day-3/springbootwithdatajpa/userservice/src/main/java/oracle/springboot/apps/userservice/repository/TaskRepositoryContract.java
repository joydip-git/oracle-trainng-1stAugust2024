package oracle.springboot.apps.userservice.repository;

import org.springframework.data.repository.CrudRepository;

import oracle.springboot.apps.userservice.models.Task;

public interface TaskRepositoryContract extends CrudRepository<Task, Integer> {

}
