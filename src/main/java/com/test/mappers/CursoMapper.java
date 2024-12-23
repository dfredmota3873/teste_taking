package com.test.mappers;

import com.test.dto.request.CursoRequest;
import com.test.dto.response.CursoResponse;
import com.test.dto.response.ProfessorResponse;
import com.test.entity.CursoEntity;
import com.test.entity.ProfessorEntity;
import jakarta.enterprise.context.RequestScoped;

import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
public class CursoMapper {

    public static CursoResponse toResponse(CursoEntity cursoEntity) {

        return CursoResponse.builder()
                .id(cursoEntity.getId())
                .nome(cursoEntity.getNome())
                .descricao(cursoEntity.getDescricao())
                .professorResponse(ProfessorMapper.toResponse(cursoEntity.getProfessor()))

                .build();
    }

    public static CursoEntity toEntity(CursoRequest cursoRequest) {

        return CursoEntity.builder()
                .ativo(cursoRequest.getAtivo())
                .descricao(cursoRequest.getDescricao())
                .nome(cursoRequest.getNome())
                .build();

    }

    public static List<CursoResponse> toResponseList(List<CursoEntity> cursoEntityList) {
        return cursoEntityList
                .stream()
                .map(CursoMapper::toResponse)
                .collect(Collectors.toList());
    }
}
