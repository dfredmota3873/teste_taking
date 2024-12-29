package com.test.controller;

import com.test.dto.request.AlunoRequestDTO;
import com.test.dto.response.AlunoResponseDTO;
import com.test.entity.Aluno;
import com.test.mappers.AlunoMapper;
import com.test.service.AlunoService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.stream.Collectors;

@Path("/alunos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AlunoController {

    @Inject
    AlunoService alunoService;

    @Inject
    AlunoMapper alunoMapper;

    @POST
    public Response create(@Valid AlunoRequestDTO alunoRequest) {
        Aluno aluno = alunoMapper.toEntity(alunoRequest);
        AlunoResponseDTO response = alunoMapper.toResponse(alunoService.create(aluno));
        return Response.status(Response.Status.CREATED).entity(response).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        Aluno aluno = alunoService.findById(id);
        if (aluno != null) {
            AlunoResponseDTO response = alunoMapper.toResponse(aluno);
            return Response.ok(response).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    public List<AlunoResponseDTO> findAll() {
        return alunoService.findAll().stream()
                .map(alunoMapper::toResponse)
                .collect(Collectors.toList());
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, @Valid AlunoRequestDTO alunoRequest) {
        Aluno updatedAluno = alunoMapper.toEntity(alunoRequest);
        updatedAluno.setId(id); // Setando o ID para a entidade que será atualizada
        AlunoResponseDTO response = alunoMapper.toResponse(alunoService.update(id, updatedAluno));
        if (response != null) {
            return Response.ok(response).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        if (alunoService.delete(id)) {
            return Response.noContent().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}