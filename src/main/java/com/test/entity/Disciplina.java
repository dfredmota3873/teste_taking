package com.test.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Data
@Entity
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "disciplinas")
@ToString

public class Disciplina {

    @Id
    @SequenceGenerator(name = "seq", sequenceName = "disciplinas_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private Long id;

    private String nome;

    private Integer creditos;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Usuario professor;

    @ManyToOne
    @JoinColumn(name = "semestre_id")
    private Semestre semestre;

}
