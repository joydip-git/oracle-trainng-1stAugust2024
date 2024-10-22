package oracle.springboot.apps.userservice.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import oracle.springboot.apps.userservice.services.TaskServiceManager;
import oracle.springboot.apps.userservice.services.UserServiceManager;
import oracle.springboot.apps.userservice.models.Task;
import oracle.springboot.apps.userservice.models.User;

@RestController
@RequestMapping(path = "api/tasks")
public class TaskController {

    @Autowired
    private TaskServiceManager taskService;

    @Autowired
    private UserServiceManager userService;

    @GetMapping(path = "", produces = "application/json")
    public ResponseEntity<List<Task>> getTasks() {
        try {
            List<Task> all = taskService.getAll();
            // pass Optional<T> to of() method
            return ResponseEntity.of(Optional.of(all));
        } catch (Exception e) {
            return ResponseEntity
                    .of(ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage()))
                    .build();
        }
    }

    @GetMapping(path = "{id}", produces = "application/json")
    public ResponseEntity<Task> getTask(@PathVariable(name = "id") int id) {
        try {
            Task found = taskService.get(id);
            if (found != null) {
                return ResponseEntity.ok(found);
            } else
                return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping(path = "add/{userId}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Object> addTask(@RequestBody Task task,
            @PathVariable(name = "userId", required = false) Integer userId) {
        try {
            System.out.println(task);
            if (userId != null) {
                User existingUser = userService.get(userId);
                existingUser.getTasks().add(task);
                task.setUser(existingUser);
                Task added = taskService.add(task);
                if (added != null) {
                    URI location = ServletUriComponentsBuilder
                            .fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(
                                    task.getId())
                            .toUri();

                    return ResponseEntity
                            .created(location)
                            .build();
                } else
                    return ResponseEntity
                            .internalServerError()
                            .build();
            } else {
                return ResponseEntity
                        .status(
                                HttpStatus.NO_CONTENT)
                        .build();
            }
        } catch (Exception e) {
            return ResponseEntity
                    .status(
                            HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    @DeleteMapping(path = "delete/{id}", produces = "application/json")
    public ResponseEntity<Object> deleteTask(@PathVariable(name = "id") int id) {
        try {
            boolean status = taskService.delete(id);
            if (status) {
                URI location = ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .buildAndExpand(id)
                        .toUri();

                return ResponseEntity
                        .created(location)
                        .build();
            } else
                return ResponseEntity
                        .internalServerError()
                        .build();
        } catch (Exception e) {
            return ResponseEntity
                    .status(
                            HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    @PutMapping(path = "update/{id}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Object> updateTask(@RequestBody Task task, @PathVariable(name = "id") int id) {
        try {
            Task updated = taskService.update(id, task);
            if (updated != null) {
                URI location = ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .buildAndExpand()
                        .toUri();

                return ResponseEntity
                        .created(location)
                        .build();
            } else
                return ResponseEntity
                        .internalServerError()
                        .build();
        } catch (Exception e) {
            return ResponseEntity
                    .status(
                            HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

}
