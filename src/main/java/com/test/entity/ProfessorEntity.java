package com.test.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
    private Long id;

    private String nome;

    private String email;

    @OneToMany(mappedBy = "professor")
    private List<CursoEntity> cursos;

}
