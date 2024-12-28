package com.test.dto.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DisciplinaRequestDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotNull(message = "Número de créditos é obrigatório")
    private Integer creditos;

    @NotNull(message = "ID do professor é obrigatório")
    private Long professorId;

    @NotNull(message = "ID do semestre é obrigatório")
    private Long semestreId;
}
