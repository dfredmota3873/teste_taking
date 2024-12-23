package com.test.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ProfessorResponse {

    private final Long id;
    private final String nome;
    private final String email;
}
