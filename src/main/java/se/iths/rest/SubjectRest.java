package se.iths.rest;

import se.iths.entity.Subject;
import se.iths.service.SubjectService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("subjects")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SubjectRest {

    @Inject
    SubjectService subjectService;

    @GET
    public Response getAll() {
        List<Subject> subjects = subjectService.getAll();
        return Response.ok(subjects).build();
    }

    /*@Path("{id}")
    @GET
    public Response getById(@PathParam("id") Long id) {
        Subject subject = subjectService.getById(id);
        return Response.ok(subject).build();
    }*/

    @Path("{subject}")
    @GET
    public Response getAllInfo(@PathParam("subject") String subject) {
        Subject allInfoSubject = subjectService.getBySubject(subject);
        return Response.ok(allInfoSubject).build();
    }
}
