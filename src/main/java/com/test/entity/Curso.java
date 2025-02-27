package com.test.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "cursos")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class Curso {

    @Id
    @SequenceGenerator(name = "seq", sequenceName = "cursos_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private Long id;

    private String nome;

    private String descricao;

    private Boolean ativo;

    @OneToMany(mappedBy = "curso")
    private List<Semestre> semestres;

    @ManyToOne
    @JoinColumn(name = "coordenador_id")
    private Usuario coordenador;

}
