package com.test.controller;

import com.test.dto.request.UsuarioRequestDTO;
import com.test.dto.response.UsuarioResponseDTO;
import com.test.entity.Usuario;
import com.test.mappers.UsuarioMapper;
import com.test.service.UsuarioService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.stream.Collectors;

@Path("/usuarios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioController {

    @Inject
    UsuarioService usuarioService;


    @POST
    public Response create(UsuarioRequestDTO usuarioRequest) {
        Usuario usuario = UsuarioMapper.toEntity(usuarioRequest);
        UsuarioResponseDTO response = UsuarioMapper.toResponse(usuarioService.create(usuario));
        return Response.status(Response.Status.CREATED).entity(response).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        Usuario usuario = usuarioService.findById(id);
        if (usuario != null) {
            UsuarioResponseDTO response = UsuarioMapper.toResponse(usuario);
            return Response.ok(response).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    public List<UsuarioResponseDTO> findAll() {
        return usuarioService.findAll().stream()
                .map(UsuarioMapper::toResponse)
                .collect(Collectors.toList());
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, @Valid UsuarioRequestDTO usuarioRequest) {
        Usuario usuario = UsuarioMapper.toEntity(usuarioRequest);
        usuario.setId(id); // Definindo ID para a atualização
        Usuario updatedUsuario = usuarioService.update(id, usuario);
        if (updatedUsuario != null) {
            UsuarioResponseDTO response = UsuarioMapper.toResponse(updatedUsuario);
            return Response.ok(response).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        if (usuarioService.delete(id)) {
            return Response.noContent().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}