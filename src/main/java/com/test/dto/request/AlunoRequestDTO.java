package com.test.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlunoRequestDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotNull(message = "ID do curso é obrigatório")
    private Long cursoId;

    @NotBlank(message = "Email é obrigatório")
    private String email;

    private Boolean ativo;
}