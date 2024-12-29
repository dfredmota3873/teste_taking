package com.test.mappers;

import com.test.dto.request.UsuarioRequestDTO;
import com.test.dto.response.UsuarioResponseDTO;
import com.test.entity.Usuario;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class UsuarioMapper {

    public static Usuario toEntity(UsuarioRequestDTO dto) {
        if (dto == null) {
            return null;
        }
        return Usuario.builder()
                .nome(dto.getNome())
                .email(dto.getEmail())
                .perfil(dto.getPerfil())
                .build();
    }

    public static UsuarioResponseDTO toResponse(Usuario entity) {
        if (entity == null) {
            return null;
        }
        return UsuarioResponseDTO.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .email(entity.getEmail())
                .perfil(entity.getPerfil())
                .build();
    }
}
