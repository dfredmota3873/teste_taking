package com.test.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Data
@Entity
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cursos")
@ToString
public class CursoEntity {

    @Id
    @SequenceGenerator(name = "seq", sequenceName = "cursos_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private Long id;

    private String nome;

    private String descricao;

    private Boolean ativo;

    @ManyToOne
    @JoinColumn(name = "id_professor")
    private ProfessorEntity professor;
}
