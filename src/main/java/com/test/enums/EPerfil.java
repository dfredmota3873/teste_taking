package com.test.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum EPerfil {

    ADM("ADMINISTRADOR"),
    PROFESSOR("PROFESSOR"),
    COORDENADOR("COORDENADOR"),
    ALUNO("ALUNO");

    private final String value;

    public static EPerfil of(final String value){
        return Stream.of(values())
                .filter(e -> e.name().equals(value) || e.getValue().equals(value))
                .findFirst()
                .orElse(null);
    }
}
