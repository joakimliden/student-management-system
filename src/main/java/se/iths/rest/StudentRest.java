package se.iths.rest;

import se.iths.entity.Student;
import se.iths.exception.CreateStudentException;
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
                .entity(student)
                .build();
    }

    @GET
    public Response getAll() {
        List<Student> students = studentService.getAll();
        return Response.ok(students).build();
    }

    @Path("{id}")
    @GET
    public Response getById(@PathParam("id") Long id) {
        Student student = studentService.getById(id);
        return Response.ok(student).build();
    }

    @Path("{id}")
    @PUT
    public Response update(@PathParam("id") Long id, Student student) {
        try {
            studentService.update(id, student);
        } catch (Exception e) {
            throw new CreateStudentException("firstName, lastName, email are mandatory and not filled correct");
        }
        return Response.ok(student).build();
    }

    @Path("{id}")
    @DELETE
    public Response delete(@PathParam("id") Long id) {
        studentService.delete(id);
        return Response.noContent().build();
    }

    @Path("lastname")
    @GET
    public Response getByLastName(@QueryParam("lastName") String lastName) {
        List<Student> students = studentService.getByLastName(lastName);
        return Response.ok(students).build();
    }
}
