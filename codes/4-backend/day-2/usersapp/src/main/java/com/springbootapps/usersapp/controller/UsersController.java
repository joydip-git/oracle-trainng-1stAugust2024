package com.springbootapps.usersapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api")
public class UsersController {

    @GetMapping(path = "users")
    public String getUsers() {
        return "users";
    }
}
