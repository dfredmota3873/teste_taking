package com.test.controller;

import com.test.dto.request.MatrizCurricularRequestDTO;
import com.test.dto.response.MatrizCurricularResponseDTO;
import com.test.entity.MatrizCurricular;
import com.test.mappers.MatrizCurricularMapper;
import com.test.service.MatrizCurricularService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


import java.util.List;
import java.util.stream.Collectors;

@Path("/matrizes-curriculares")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MatrizCurricularController {

    @Inject
    MatrizCurricularService matrizCurricularService;

    @Inject
    MatrizCurricularMapper matrizCurricularMapper;

    @POST
    public Response create(@Valid MatrizCurricularRequestDTO matrizCurricularRequest) {
        MatrizCurricular matrizCurricular = matrizCurricularMapper.toEntity(matrizCurricularRequest);
        MatrizCurricularResponseDTO response = matrizCurricularMapper.toResponse(matrizCurricularService.create(matrizCurricular));
        return Response.status(Response.Status.CREATED).entity(response).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        MatrizCurricular matrizCurricular = matrizCurricularService.findById(id);
        if (matrizCurricular != null) {
            MatrizCurricularResponseDTO response = matrizCurricularMapper.toResponse(matrizCurricular);
            return Response.ok(response).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    public List<MatrizCurricularResponseDTO> findAll() {
        return matrizCurricularService.findAll().stream()
                .map(matrizCurricularMapper::toResponse)
                .collect(Collectors.toList());
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, @Valid MatrizCurricularRequestDTO matrizCurricularRequest) {
        MatrizCurricular matrizCurricular = matrizCurricularMapper.toEntity(matrizCurricularRequest);
        matrizCurricular.setId(id); // Definindo o ID para atualização
        MatrizCurricular updatedMatriz = matrizCurricularService.update(id, matrizCurricular);
        if (updatedMatriz != null) {
            MatrizCurricularResponseDTO response = matrizCurricularMapper.toResponse(updatedMatriz);
            return Response.ok(response).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        if (matrizCurricularService.delete(id)) {
            return Response.noContent().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
