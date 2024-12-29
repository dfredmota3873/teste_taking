package com.test.mappers;

import com.test.dto.request.AlunoRequestDTO;
import com.test.dto.response.AlunoResponseDTO;
import com.test.entity.Aluno;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class AlunoMapper {

    public Aluno toEntity(AlunoRequestDTO dto) {
        if (dto == null) {
            return null;
        }
        Aluno aluno = new Aluno();
        aluno.setNome(dto.getNome());
        aluno.setEmail(dto.getEmail());
        aluno.setAtivo(dto.getAtivo());
        return aluno;
    }

    public AlunoResponseDTO toResponse(Aluno entity) {
        if (entity == null) {
            return null;
        }
        return AlunoResponseDTO.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .email(entity.getEmail())
                .ativo(entity.getAtivo())
                .cursoId(entity.getCurso() != null ? entity.getCurso().getId() : null)
                .build();
    }
}