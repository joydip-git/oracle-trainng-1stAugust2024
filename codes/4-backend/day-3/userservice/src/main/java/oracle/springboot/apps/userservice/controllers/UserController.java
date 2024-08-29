package oracle.springboot.apps.userservice.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.websocket.server.PathParam;
import oracle.springboot.apps.userservice.models.User;
import oracle.springboot.apps.userservice.repository.UserRepository;

@RestController
@RequestMapping(path = "api")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping(path = "users", produces = "application/json")
    public List<User> getUsers() {
        return repository.getAll();
    }

    @PostMapping(path = "users/add")
    public ResponseEntity<Object> addUser(@RequestBody User user) {
        try {
            System.out.println(user);
            boolean status = repository.add(user);
            if (status) {
                URI location = ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(user.getUserId())
                        .toUri();

                return ResponseEntity.created(location).build();
            } else
                return ResponseEntity.internalServerError().build();
        } catch (Exception e) {
            throw e;
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
