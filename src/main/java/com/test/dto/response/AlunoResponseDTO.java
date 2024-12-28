package com.test.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlunoResponseDTO {

    private Long id;
    private String nome;
    private Long cursoId;
    private String email;
    private Boolean ativo;
}
