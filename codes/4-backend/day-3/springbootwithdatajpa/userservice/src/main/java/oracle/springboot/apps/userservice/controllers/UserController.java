package oracle.springboot.apps.userservice.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
import oracle.springboot.apps.userservice.repository.UserRepository;

@RestController
@RequestMapping(path = "api")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping(path = "users", produces = "application/json")
    public ResponseEntity<List<User>> getUsers() {
        try {
            List<User> all = repository.getAll();
            // pass Optional<T> to of() method
            return ResponseEntity.of(Optional.of(all));
        } catch (Exception e) {
            return ResponseEntity
                    .of(ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage()))
                    .build();
        }
    }

    @GetMapping(path = "users/{id}", produces = "application/json")
    public ResponseEntity<User> getUser(@PathVariable(name = "id") int id) {
        try {
            User found = repository.get(id);
            if (found != null) {
                return ResponseEntity.ok(found);
            } else
                return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping(path = "users/add", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Object> addUser(@RequestBody User user) {
        try {
            System.out.println(user);
            boolean status = repository.add(user);
            if (status) {
                URI location = ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(
                                user.getUserId())
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

    @DeleteMapping(path = "users/delete/{id}", produces = "application/json")
    public ResponseEntity<Object> deleteUser(@PathVariable(name = "id") int id) {
        try {
            boolean status = repository.delete(id);
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

    @PutMapping(path = "users/update/{id}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Object> updateUser(@RequestBody User user, @PathVariable(name = "id") int id) {
        try {
            boolean status = repository.update(id, user);
            if (status) {
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

    // @PostMapping(path = "users/add")
    // public String addUser(@PathParam(value = "name") String name,
    // @PathParam(value = "loc") String loc) {
    // System.out.println(name + " " + loc);
    // return repository.add(name) ? name : "could not add";
    // }
    // @PostMapping(path = "users/add/{name}/location/{loc}")
    // public String addUser(@PathVariable(name = "name") String name,
    // @PathVariable(name = "loc") String loc) {
    // System.out.println(name + " " + loc);
    // return repository.add(name) ? name : "could not add";
    // }
}
