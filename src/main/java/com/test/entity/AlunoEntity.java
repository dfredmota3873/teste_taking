package com.test.entity;

import jakarta.persistence.*;

@Table(name = "alunos")
@Entity
public class AlunoEntity {

    @Id
    private Long id;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "id_curso")
    private CursoEntity curso;

    private String email;

    private Boolean ativo;

}
