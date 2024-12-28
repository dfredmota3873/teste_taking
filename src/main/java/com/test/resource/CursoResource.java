package com.test.resource;

import com.test.dto.request.CursoRequest;
import com.test.dto.response.CursoResponseDTO;
import com.test.service.CursoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/cursos")
public class CursoResource {

    private final CursoService cursoService;

    @Inject
    public CursoResource(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @POST
    public Response save(CursoRequest request) {
        log.info("Iniciando Cadastro de Curso");
        CursoResponseDTO response = this.cursoService.salvar(request);
        log.info("Cadastro realizado com sucesso");
        return Response.ok(response).status(Response.Status.CREATED).build();
    }
}
