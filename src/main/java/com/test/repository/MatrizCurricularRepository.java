package com.test.repository;

import com.test.entity.MatrizCurricular;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MatrizCurricularRepository implements PanacheRepository<MatrizCurricular> {
}