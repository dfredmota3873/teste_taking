package com.test.dto.response;

import lombok.*;

@Builder
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CursoResponse {

    private Long id;
    private String nome;
    private String descricao;
    private Boolean ativo;
    private ProfessorResponse professorResponse;
}
