package com.test.mappers;

import com.test.dto.request.DisciplinaRequestDTO;
import com.test.dto.response.DisciplinaResponseDTO;
import com.test.entity.Disciplina;
import com.test.entity.Semestre;
import com.test.entity.Usuario;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class DisciplinaMapper {

    public static Disciplina toEntity(DisciplinaRequestDTO dto) {

        return Disciplina.builder()
                .nome(dto.getNome())
                .creditos(dto.getCreditos())
                .professor(Usuario.builder()
                        .id(dto.getProfessorId())
                        .build())
                .semestre(Semestre.builder()
                        .id(dto.getSemestreId())
                        .build())
                .build();
    }

    public static DisciplinaResponseDTO toResponse(Disciplina disciplina) {

        return DisciplinaResponseDTO.builder()
                .id(disciplina.getId())
                .nome(disciplina.getNome())
                .build();
    }
}
