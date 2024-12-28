package com.test.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SemestreRequestDTO {

    @NotBlank(message = "Número do semestre é obrigatório")
    private String numero;

    private List<Long> disciplinasIds;
}