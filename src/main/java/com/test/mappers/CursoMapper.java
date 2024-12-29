package com.test.mappers;

import com.test.dto.request.CursoRequestDTO;
import com.test.dto.response.CursoResponseDTO;
import com.test.dto.response.UsuarioResponseDTO;
import com.test.entity.Curso;
import com.test.entity.Usuario;
import jakarta.enterprise.context.RequestScoped;

import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
public class CursoMapper {


    public static CursoResponseDTO toResponse(Curso cursoEntity) {

        return CursoResponseDTO.builder()
                .id(cursoEntity.getId())
                .nome(cursoEntity.getNome())
                .ativo(cursoEntity.getAtivo())
                .descricao(cursoEntity.getDescricao())
                .coordenador(UsuarioResponseDTO.builder()
                        .id(cursoEntity.getCoordenador().getId())
                        .nome(cursoEntity.getCoordenador().getNome())
                        .email(cursoEntity.getCoordenador().getEmail())
                        .perfil(cursoEntity.getCoordenador().getPerfil()).build())
                .build();
    }

    public static Curso toEntity(CursoRequestDTO cursoRequest) {

        return Curso.builder()
                .ativo(cursoRequest.getAtivo())
                .descricao(cursoRequest.getDescricao())
                .nome(cursoRequest.getNome())
                .coordenador(Usuario.builder().id(cursoRequest.getCoordenador()).build())
                .build();

    }

    public static List<CursoResponseDTO> toResponseList(List<Curso> cursoEntityList) {
        return cursoEntityList
                .stream()
                .map(CursoMapper::toResponse)
                .collect(Collectors.toList());
    }
}
