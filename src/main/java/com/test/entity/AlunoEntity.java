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
public class AlunoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "id_curso")
    private CursoEntity curso;

    private String email;

    private Boolean ativo;

}
