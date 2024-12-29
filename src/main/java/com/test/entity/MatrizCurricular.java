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
public class MatrizCurricular {

    @Id
    @SequenceGenerator(name = "seq", sequenceName = "alunos_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "coordenador_id")
    private Usuario coordenador;
}
