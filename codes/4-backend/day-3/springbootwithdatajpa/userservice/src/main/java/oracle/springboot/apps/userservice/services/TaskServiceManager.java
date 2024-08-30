package oracle.springboot.apps.userservice.services;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oracle.springboot.apps.userservice.models.Task;
import oracle.springboot.apps.userservice.repository.TaskRepositoryContract;

@Service
public class TaskServiceManager implements ServiceContract<Task, Integer> {

    @Autowired
    private TaskRepositoryContract repository;

    @Override
    public Task add(Task data) {
        return repository.save(data);
    }

    @Override
    public Task update(Integer id, Task data) {
        Task found = repository.findById(id).get();
        if (Objects.nonNull(found.getTitle()) && !"".equalsIgnoreCase(found.getTitle())) {
            found.setTitle(data.getTitle());
        }
        found.setCompleted(data.isCompleted());
        return repository.save(found);
    }

    @Override
    public boolean delete(Integer id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public List<Task> getAll() {
        return ((List<Task>) repository.findAll());
    }

    @Override
    public Task get(Integer id) {
        return repository.findById(id).get();
    }

}
