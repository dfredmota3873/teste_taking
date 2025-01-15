package com.test.controller;

import com.test.dto.request.SemestreRequestDTO;
import com.test.dto.response.SemestreResponseDTO;
import com.test.entity.Semestre;
import com.test.exception.TestApplicationException;
import com.test.mappers.SemestreMapper;
import com.test.service.SemestreService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/semestres")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SemestreController {

    @Inject
    SemestreService semestreService;

    @POST
    public Response create(SemestreRequestDTO semestreRequestDTO) {

        SemestreResponseDTO response;

        try {

            Semestre semestre = SemestreMapper.toEntity(semestreRequestDTO);
            response = SemestreMapper.toResponse(semestreService.create(semestre));

        } catch (TestApplicationException exception) {
            return Response.status(Response.Status.BAD_REQUEST).entity(exception.getMessage()).build();
        }
        return Response.status(Response.Status.CREATED).entity(response).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        Semestre semestre = semestreService.findById(id);
        if (semestre != null) {
            SemestreResponseDTO response = SemestreMapper.toResponse(semestre);
            return Response.ok(response).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    public List<SemestreResponseDTO> findAll() {
        List<Semestre> list = semestreService.findAll();

        return SemestreMapper.toResponseList(list);
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, SemestreRequestDTO semestreRequestDTO) {
        Semestre semestre = SemestreMapper.toEntity(semestreRequestDTO);
        semestre.setId(id);
        Semestre updatedSemestre = semestreService.update(id, semestre);
        if (updatedSemestre != null) {
            SemestreResponseDTO response = SemestreMapper.toResponse(updatedSemestre);
            return Response.ok(response).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

}
