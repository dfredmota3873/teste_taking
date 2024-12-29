package com.test.service;

import com.test.entity.MatrizCurricular;
import com.test.repository.MatrizCurricularRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class MatrizCurricularService {

    private final MatrizCurricularRepository matrizCurricularRepository;

    public MatrizCurricularService(MatrizCurricularRepository matrizCurricularRepository) {
        this.matrizCurricularRepository = matrizCurricularRepository;
    }

    public List<MatrizCurricular> findAll() {
        return matrizCurricularRepository.listAll();
    }

    public MatrizCurricular findById(Long id) {
        return matrizCurricularRepository.findById(id);
    }

    @Transactional
    public MatrizCurricular create(MatrizCurricular matrizCurricular) {
        matrizCurricularRepository.persist(matrizCurricular);
        return matrizCurricular;
    }

    @Transactional
    public MatrizCurricular update(Long id, MatrizCurricular matrizCurricular) {
        MatrizCurricular existingMatriz = matrizCurricularRepository.findById(id);
        if (existingMatriz != null) {
            existingMatriz.setCurso(matrizCurricular.getCurso());
            existingMatriz.setCoordenador(matrizCurricular.getCoordenador());
            return existingMatriz;
        }
        return null;
    }

    @Transactional
    public boolean delete(Long id) {
        matrizCurricularRepository.deleteById(id);
        return true;
    }
}