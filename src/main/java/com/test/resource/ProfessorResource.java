package com.test.resource;

import com.test.service.ProfessorService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/professores")
public class ProfessorResource {

    private final ProfessorService professorService;

    @Inject
    public ProfessorResource(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GET
    public Response listar() {
        //log.info("Listando professores");
        return Response.ok(this.professorService.listar()).build();
    }
}
