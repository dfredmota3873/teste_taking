package com.test.repository;

import com.test.entity.ProfessorEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProfessorRepository implements PanacheRepository<ProfessorEntity> {

}
