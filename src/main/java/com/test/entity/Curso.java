package com.test.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@Data
@Entity
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cursos")
@ToString
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

}
