package com.test.service;

import com.test.entity.Semestre;
import com.test.repository.SemestreRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class SemestreService {

    private final SemestreRepository semestreRepository;

    public SemestreService(SemestreRepository semestreRepository) {
        this.semestreRepository = semestreRepository;
    }

    public List<Semestre> findAll() {
        return semestreRepository.listAll();
    }

    public Semestre findById(Long id) {
        return semestreRepository.findById(id);
    }

    @Transactional
    public Semestre create(Semestre semestre) {
        semestreRepository.persist(semestre);
        return semestre;
    }

    @Transactional
    public Semestre update(Long id, Semestre semestre) {
        Semestre existingSemestre = semestreRepository.findById(id);
        if (existingSemestre != null) {
            existingSemestre.setNumero(semestre.getNumero());
            existingSemestre.setDisciplinas(semestre.getDisciplinas());
            return existingSemestre;
        }
        return null;
    }

    @Transactional
    public void delete(Long id) {
        semestreRepository.deleteById(id);
    }
}
