package com.test.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "alunos")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class Aluno {

    @Id
    @SequenceGenerator(name = "seq", sequenceName = "alunos_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private Long id;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "id_curso")
    private Curso curso;

    private String email;

    private Boolean ativo;

}
