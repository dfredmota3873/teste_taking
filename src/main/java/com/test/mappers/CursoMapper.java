package com.test.mappers;

import com.test.dto.request.CursoRequest;
import com.test.dto.response.CursoResponseDTO;
import com.test.entity.Curso;
import jakarta.enterprise.context.RequestScoped;

import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
public class CursoMapper {

    public static CursoResponseDTO toResponse(Curso cursoEntity) {

        return CursoResponseDTO.builder()
                .id(cursoEntity.getId())
                .nome(cursoEntity.getNome())
                .descricao(cursoEntity.getDescricao())
                .professorResponse(ProfessorMapper.toResponse(cursoEntity.getProfessor()))

                .build();
    }

    public static Curso toEntity(CursoRequest cursoRequest) {

        return Curso.builder()
                .ativo(cursoRequest.getAtivo())
                .descricao(cursoRequest.getDescricao())
                .nome(cursoRequest.getNome())
                .build();

    }

    public static List<CursoResponseDTO> toResponseList(List<Curso> cursoEntityList) {
        return cursoEntityList
                .stream()
                .map(CursoMapper::toResponse)
                .collect(Collectors.toList());
    }
}
