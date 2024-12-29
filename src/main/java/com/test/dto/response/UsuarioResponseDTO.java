package com.test.dto.response;

import com.test.enums.EPerfil;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioResponseDTO {

    private Long id;
    private String nome;
    private String email;
    private EPerfil perfil;
}