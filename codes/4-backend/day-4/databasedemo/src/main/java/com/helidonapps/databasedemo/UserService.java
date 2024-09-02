package com.helidonapps.databasedemo;

import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/user")
@RequestScoped
public class UserService {

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<String> getUsers() {
        return new ArrayList<String>(List.of("anil", "sunil"));
    }
}
