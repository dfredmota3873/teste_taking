package com.test.mappers;


import com.test.dto.request.SemestreRequestDTO;
import com.test.dto.response.DisciplinaResponseDTO;
import com.test.dto.response.SemestreResponseDTO;
import com.test.entity.Curso;
import com.test.entity.Semestre;
import jakarta.enterprise.context.RequestScoped;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
public class SemestreMapper {

    public static Semestre toEntity(SemestreRequestDTO requestDTO) {

        return  Semestre.builder()
                .numero(requestDTO.getNumero())
                .curso(Curso.builder()
                        .id(requestDTO.getIdCurso())
                        .build())
                .build();
    }

    public static SemestreResponseDTO toResponse(Semestre entity) {

        List<DisciplinaResponseDTO> disciplinas = new ArrayList<>();

        if(entity.getDisciplinas() != null){
            disciplinas = entity.getDisciplinas().stream().map(DisciplinaMapper::toResponse).collect(Collectors.toList());
        }

        return SemestreResponseDTO.builder()
                .id(entity.getId())
                .numero(entity.getNumero())
                .curso(CursoMapper.toResponse(entity.getCurso()))
                .disciplinaResponseDTO(disciplinas)
                .build();
    }

    public static List<SemestreResponseDTO> toResponseList(List<Semestre> semestreList) {
        return semestreList
                .stream()
                .map(SemestreMapper::toResponse)
                .collect(Collectors.toList());
    }
}
