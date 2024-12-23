package com.test.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name = "cursos")
@Entity
public class CursoEntity {

    @Id
    private Long id;

    private String nome;

    private String descricao;

    private Boolean ativo;

    @ManyToOne
    private ProfessorEntity professor;
}
