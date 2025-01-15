package com.test.mappers;

import com.test.dto.request.MatrizCurricularRequestDTO;
import com.test.dto.response.MatrizCurricularResponseDTO;
import com.test.entity.MatrizCurricular;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class MatrizCurricularMapper {

    @Inject
    CursoMapper cursoMapper;

    public MatrizCurricular toEntity(MatrizCurricularRequestDTO dto) {
        if (dto == null) {
            return null;
        }
        MatrizCurricular matrizCurricular = new MatrizCurricular();
         return matrizCurricular;
    }

    public MatrizCurricularResponseDTO toResponse(MatrizCurricular entity) {
        if (entity == null) {
            return null;
        }
        return MatrizCurricularResponseDTO.builder()
                .id(entity.getId())
                .cursoId(entity.getCurso().getId())
                .coordenadorId(entity.getCoordenador().getId())
                .build();
    }
}