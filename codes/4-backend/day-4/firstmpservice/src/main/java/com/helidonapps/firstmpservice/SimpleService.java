package com.helidonapps.firstmpservice;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

@Path("/simple")
@RequestScoped
public class SimpleService {

    private String message;
    @Inject
    @Named("main")
    private DataSource ds;

    @Inject
    public SimpleService(@ConfigProperty(name = "app.messageValue") String message) {
        this.message = message;
    }

    @GET
    @Path("/message")
    @Produces(value = MediaType.TEXT_PLAIN)
    public String getRespone() {
        try (Connection connection = ds.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("select * from users where user_id=?");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                System.out.println(result.getString("user_name"));
            }
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (message == null || message == "") ? "no data" : message;

    }
}
