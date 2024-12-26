package aldev.code.tech.controller;

import aldev.code.tech.service.GeneratorService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.concurrent.ExecutionException;

@Path("/generator-service/v1")
@Produces(MediaType.APPLICATION_JSON)
public class GeneratorController {

    @Inject
    GeneratorService generatorService;

    @GET
    @Path("/test")
    public Response testMethod(@QueryParam("text") String text) throws ExecutionException, InterruptedException {
        return generatorService.testMethod(text);
    }

    @GET
    @Path("/actor")
    public Response inquiryActorPaginate(@QueryParam("page") int page, @QueryParam("size") int size) {
        return generatorService.inquiryActorPaginate(page,size);
    }

    @POST
    @Path("/session-export")
    public Response createSessionExport(@QueryParam("referenceId") String referenceId) {
        return generatorService.createSessionExport(referenceId);
    }

}
