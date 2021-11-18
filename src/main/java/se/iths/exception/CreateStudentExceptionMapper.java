package se.iths.exception;

import se.iths.entity.ErrorMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class CreateStudentExceptionMapper implements ExceptionMapper<CreateStudentException> {


    @Override
    public Response toResponse(CreateStudentException e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage(), 400, "BAD REQUEST");
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(errorMessage)
                .build();
    }
}
