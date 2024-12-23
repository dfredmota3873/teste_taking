package com.test.mappers;

import com.test.dto.response.ProfessorResponse;
import com.test.entity.ProfessorEntity;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
public class ProfessorMapper {


    public static ProfessorResponse toResponse(ProfessorEntity professorEntity) {

        return ProfessorResponse.builder()
                .id(professorEntity.getId())
                .nome(professorEntity.getNome())
                .email(professorEntity.getEmail())
                .build();
    }

    public static List<ProfessorResponse> toResponseList(List<ProfessorEntity> professorEntityList) {
        return professorEntityList
                .stream()
                .map(ProfessorMapper::toResponse)
                .collect(Collectors.toList());
    }
}
