package com.test.dto.request;

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
    private Integer numero;

    private List<Long> disciplinasIds;

    private Long idCurso;
}