package com.test.controller;

import com.test.dto.request.CursoRequestDTO;
import com.test.dto.response.CursoResponseDTO;
import com.test.entity.Curso;
import com.test.exception.TestApplicationException;
import com.test.mappers.CursoMapper;
import com.test.service.CursoService;
import io.quarkus.security.identity.SecurityIdentity;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/cursos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CursoController {

    @Inject
    CursoService cursoService;

    @Inject
    SecurityIdentity identity;

    @POST
    public Response create(CursoRequestDTO cursoRequest) throws TestApplicationException {

        CursoResponseDTO response = null;

        try {

            Curso curso = CursoMapper.toEntity(cursoRequest);
            response = CursoMapper.toResponse(cursoService.create(curso));

        } catch (TestApplicationException exception) {
            return Response.status(Response.Status.BAD_REQUEST).entity(exception.getMessage()).build();
        }

        return Response.status(Response.Status.CREATED).entity(response).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        Curso curso = cursoService.findById(id);
        if (curso != null) {
            CursoResponseDTO response = CursoMapper.toResponse(curso);
            return Response.ok(response).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    public List<CursoResponseDTO> findAll() {
        List<Curso> list = cursoService.findAll();

        return CursoMapper.toResponseList(list);
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, CursoRequestDTO cursoRequest) {
        Curso curso = CursoMapper.toEntity(cursoRequest);
        curso.setId(id);
        Curso updatedCurso = cursoService.update(id, curso);
        if (updatedCurso != null) {
            CursoResponseDTO response = CursoMapper.toResponse(updatedCurso);
            return Response.ok(response).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        if (cursoService.delete(id)) {
            return Response.noContent().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}