package com.test.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MatrizCurricularResponseDTO {

    private Long id;
    private Long cursoId;
    private Long coordenadorId;
}
