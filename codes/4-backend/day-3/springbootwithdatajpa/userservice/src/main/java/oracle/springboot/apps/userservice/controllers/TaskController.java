package oracle.springboot.apps.userservice.controllers;

import java.net.URI;
import java.util.List;

import org.apache.el.stream.Optional;

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

import oracle.springboot.apps.userservice.models.User;
import oracle.springboot.apps.userservice.services.TaskServiceManager;
import oracle.springboot.apps.userservice.models.Task;

@RestController
@RequestMapping(path = "api/tasks")
public class TaskController {
    @Autowired
    private TaskServiceManager service;

    @GetMapping(path = "", produces = "application/json")
    public ResponseEntity<List<Task>> getTasks() {
        try {
            List<Task> all = service.getAll();
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
            Task found = service.get(id);
            if (found != null) {
                return ResponseEntity.ok(found);
            } else
                return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping(path = "add", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Object> addTask(@RequestBody Task task) {
        try {
            System.out.println(task);
            Task added = service.add(task);
            if (added != null) {
                URI location = ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(
                                task.getUserId())
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

    @DeleteMapping(path = "delete/{id}", produces = "application/json")
    public ResponseEntity<Object> deleteTask(@PathVariable(name = "id") int id) {
        try {
            boolean status = service.delete(id);
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
            Task updated = service.update(id, task);
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
