package com.test.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PerfilResponseDTO {
    private Long id;
    private String nome;
    private Boolean ativo;
    private Boolean isAdmin;
}
