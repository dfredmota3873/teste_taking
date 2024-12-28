package com.test.repository;

import com.test.entity.Semestre;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SemestreRepository implements PanacheRepository<Semestre> {

    public Semestre findByNumero(String numero) {
        return find("numero", numero).firstResult();
    }
}
