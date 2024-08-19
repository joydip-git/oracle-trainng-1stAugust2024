package com.java.restapis;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ProductServiceExceptionMapper implements ExceptionMapper<ProductServieException> {

    @Override
    public Response toResponse(ProductServieException exception) {
        return Response
                .status(500)
                .entity(exception)
                .build();
    }

}
