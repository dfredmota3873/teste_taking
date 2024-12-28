package com.test.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PerfilRequestDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    private Boolean ativo;

    private Boolean isAdmin;
}
