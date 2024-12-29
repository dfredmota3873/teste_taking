package com.test.dto.request;

import lombok.*;
import jakarta.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MatrizCurricularRequestDTO {

    @NotNull(message = "ID do curso é obrigatório")
    private Long cursoId;

    @NotNull(message = "ID do coordenador é obrigatório")
    private Long coordenadorId;
}