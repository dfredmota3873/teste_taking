package com.test.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "professores")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ProfessorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    @OneToMany(mappedBy = "professor")
    private List<CursoEntity> cursos;

}
