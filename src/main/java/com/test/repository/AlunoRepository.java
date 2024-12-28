package com.test.repository;

import com.test.entity.Aluno;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class AlunoRepository implements PanacheRepository<Aluno> {
    // Aqui você pode adicionar métodos de consulta personalizados, se necessário

    public Aluno findByEmail(String email) {
        return find("email", email).firstResult();
    }

    public List<Aluno> findByCursoId(Long cursoId) {
        return find("curso.id", cursoId).list();
    }
}
