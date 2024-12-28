package com.test.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DisciplinaResponseDTO {

    private Long id;
    private String nome;
    private Integer creditos;
    private Long professorId;
    private Long semestreId;
}
