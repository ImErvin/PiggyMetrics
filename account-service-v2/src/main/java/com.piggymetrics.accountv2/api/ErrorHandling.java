package com.piggymetrics.accountv2.api;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ErrorHandling implements ExceptionMapper<IllegalArgumentException> {

    @Override
    public Response toResponse(IllegalArgumentException e) {
        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity("Illegal Argument")
                .type(MediaType.TEXT_PLAIN)
                .build();
    }
}
