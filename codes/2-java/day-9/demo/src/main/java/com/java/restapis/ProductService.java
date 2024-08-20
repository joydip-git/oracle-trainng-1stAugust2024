package com.java.restapis;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.java.restapis.entities.Product;
import com.java.restapis.repository.RepositoryContract;
import com.java.restapis.repository.ProductRepository;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */

@Path("products")
public class ProductService {

    private RepositoryContract<Product> repository;

    public ProductService() throws ProductServieException {
        try {
            this.repository = new ProductRepository();
        } catch (ClassNotFoundException | IOException | SQLException e) {
            throw new ProductServieException(e.getMessage());
        }
    }

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getIt() throws ProductServieException {
        try {
            return repository.getAll();
        } catch (Exception e) {
            throw new ProductServieException(e.getMessage());
        }
    }
}
