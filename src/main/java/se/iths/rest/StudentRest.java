package se.iths.rest;

import se.iths.entity.Student;
import se.iths.service.StudentService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("students")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StudentRest {

    @Inject
    StudentService studentService;

    @POST
    public Response create(Student student) {
        studentService.create(student);
        return Response
                .created(URI.create("/student-management-system/api/v1/students/" + student
                .getId()))
                .build();
    }

    @GET
    public Response getAll() {
        List<Student> students = studentService.getAll();
        if (students.isEmpty())
            return Response.noContent().build();
        return Response.ok(students).build();
    }

    @Path("{id}")
    @GET
    public Response getById(@PathParam("id") Long id) {
        Student student = studentService.getById(id);
        if (student == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        else
            return Response.ok(student).build();
    }

    @Path("{id}") //TODO exception if id not found
    @PUT
    public Response update(@PathParam("id") Long id, Student student) {
        studentService.update(id, student);
        return Response.ok(student).build(); // 200 OK
    }

    @Path("{id}") // TODO exception if id not found
    @DELETE
    public Response delete(@PathParam("id") Long id) {
        studentService.delete(id);
        return Response.noContent().build(); // 204 NO CONTENT
    }

    @Path("lastname") // TODO exception if lastname not found
    @GET
    public Response getByLastName(@QueryParam("lastName") String lastName) {
        List<Student> students = studentService.getByLastName(lastName);
        if (students.isEmpty())
            return Response.noContent().build();
        return Response.ok(students).build();
    }
}
