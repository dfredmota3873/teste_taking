package com.test.repository;

import com.test.entity.Perfil;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class PerfilRepository implements PanacheRepository<Perfil> {

    public Perfil findByNome(String nome) {
        return find("nome", nome).firstResult();
    }

    public List<Perfil> findByAtivo(Boolean ativo) {
        return find("ativo", ativo).list();
    }
}
