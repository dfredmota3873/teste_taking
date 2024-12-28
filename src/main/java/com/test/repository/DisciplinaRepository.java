package com.test.repository;

import com.test.entity.Disciplina;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class DisciplinaRepository implements PanacheRepository<Disciplina> {

    public Disciplina findByNome(String nome) {
        return find("nome", nome).firstResult();
    }

    public List<Disciplina> findBySemestreId(Long semestreId) {
        return find("semestre.id", semestreId).list();
    }
}