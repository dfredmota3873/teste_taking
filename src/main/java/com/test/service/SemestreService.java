package com.test.service;

import com.test.entity.Curso;
import com.test.entity.Semestre;
import com.test.exception.TestApplicationException;
import com.test.repository.CursoRepository;
import com.test.repository.SemestreRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class SemestreService {

    private final SemestreRepository semestreRepository;

    private final CursoRepository cursoRepository;

    public SemestreService(SemestreRepository semestreRepository,
                           CursoRepository cursoRepository) {
        this.semestreRepository = semestreRepository;
        this.cursoRepository = cursoRepository;
    }

    public List<Semestre> findAll() {
        return semestreRepository.listAll();
    }

    public Semestre findById(Long id) {
        return semestreRepository.findById(id);
    }

    @Transactional
    public Semestre create(Semestre semestre) throws TestApplicationException {

        Curso curso = cursoRepository.findByIdOptional(semestre.getCurso().getId())
                .orElseThrow(() -> new TestApplicationException("O curso com id : " + semestre.getCurso().getId() + " nao existe."));

        semestre.setCurso(curso);

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
