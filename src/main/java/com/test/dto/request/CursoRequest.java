package com.test.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class CursoRequest {

    private Long id;
    @Size(min = 2, max = 200)
    private String nome;
    @NotEmpty(message = "A descrição do curso é obrigatória.")
    private String descricao;
    private Boolean ativo;
    @NotNull(message = "O professor é obrigatório")
    private Long professor;
}
