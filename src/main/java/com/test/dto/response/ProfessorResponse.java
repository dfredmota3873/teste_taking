package com.test.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ProfessorResponse {

    private Long id;
    private String nome;
    private String email;
}
