package com.test.entity;

import com.test.enums.EPerfil;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "usuarios")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class Usuario {

    @Id
    @SequenceGenerator(name = "seq", sequenceName = "usuarios_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private Long id;

    private String nome;

    private String email;

    @Enumerated(EnumType.STRING)
    private EPerfil perfil;

}
