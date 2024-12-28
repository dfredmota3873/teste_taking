package com.test.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "perfil")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class Perfil {

    @Id
    @SequenceGenerator(name = "seq", sequenceName = "perfil_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private Long id;

    private String nome;

    private Boolean ativo;

    private Boolean isAdmin;
}
