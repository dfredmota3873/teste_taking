package com.test.dto.response;

import lombok.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SemestreResponseDTO {
    private Long id;
    private Integer numero;
    private List<DisciplinaResponseDTO> disciplinaResponseDTO;
    private CursoResponseDTO curso;
}