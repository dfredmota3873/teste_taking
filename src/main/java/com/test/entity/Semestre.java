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
@Table(name = "semestre")
@ToString
public class Semestre {

    @Id
    @SequenceGenerator(name = "seq", sequenceName = "semestre_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private Long id;

    private String numero;

    @OneToMany(mappedBy = "semestre")
    private List<Disciplina> disciplinas;

}
