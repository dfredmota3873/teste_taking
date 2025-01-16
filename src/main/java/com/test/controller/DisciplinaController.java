package com.test.controller;

import com.test.dto.request.DisciplinaRequestDTO;
import com.test.dto.response.DisciplinaResponseDTO;
import com.test.entity.Disciplina;
import com.test.exception.TestApplicationException;
import com.test.mappers.DisciplinaMapper;
import com.test.service.DisciplinaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/disciplinas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DisciplinaController {


    @Inject
    DisciplinaService disciplinaService;

    @POST
    public Response create(DisciplinaRequestDTO requestDTO) throws TestApplicationException {

        DisciplinaResponseDTO response;

        try {

            Disciplina disciplina = DisciplinaMapper.toEntity(requestDTO);
            response = DisciplinaMapper.toResponse(disciplinaService.create(disciplina));

        } catch (TestApplicationException exception) {
            return Response.status(Response.Status.BAD_REQUEST).entity(exception.getMessage()).build();
        }
        return Response.status(Response.Status.CREATED).entity(response).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        Disciplina disciplina = disciplinaService.findById(id);
        if (disciplina != null) {
            DisciplinaResponseDTO response = DisciplinaMapper.toResponse(disciplina);
            return Response.ok(response).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    public List<DisciplinaResponseDTO> findAll() {
        List<Disciplina> list = disciplinaService.findAll();
        return DisciplinaMapper.toResponseList(list);
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, DisciplinaRequestDTO disciplinaRequestDTO) {
        Disciplina disciplina = DisciplinaMapper.toEntity(disciplinaRequestDTO);
        disciplina.setId(id);
        Disciplina updatedDisciplina = disciplinaService.update(id, disciplina);
        if (updatedDisciplina != null) {
            DisciplinaResponseDTO response = DisciplinaMapper.toResponse(updatedDisciplina);
            return Response.ok(response).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

}
