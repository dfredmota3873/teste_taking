package com.test.mappers;

import com.test.dto.request.MatrizCurricularRequestDTO;
import com.test.dto.response.MatrizCurricularResponseDTO;
import com.test.entity.MatrizCurricular;
import com.test.mappers.CursoMapper;
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
        // Aqui você pode precisar buscar as entidades Curso e Usuario, dependendo da lógica da sua aplicação.
        MatrizCurricular matrizCurricular = new MatrizCurricular();
         return matrizCurricular;
    }

    public MatrizCurricularResponseDTO toResponse(MatrizCurricular entity) {
        if (entity == null) {
            return null;
        }
        return MatrizCurricularResponseDTO.builder()
                .id(entity.getId())
                .cursoId(entity.getCurso().getId()) // Assumindo que Curso tem método getId
                .coordenadorId(entity.getCoordenador().getId()) // Assumindo que Usuario tem método getId
                .build();
    }
}