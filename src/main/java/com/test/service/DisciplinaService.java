package com.test.service;

import com.test.entity.Disciplina;
import com.test.repository.DisciplinaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class DisciplinaService {

    private final DisciplinaRepository disciplinaRepository;

    public DisciplinaService(DisciplinaRepository disciplinaRepository) {
        this.disciplinaRepository = disciplinaRepository;
    }

    public List<Disciplina> findAll() {
        return disciplinaRepository.listAll();
    }

    public Disciplina findById(Long id) {
        return disciplinaRepository.findById(id);
    }

    @Transactional
    public Disciplina create(Disciplina disciplina) {
        disciplinaRepository.persist(disciplina);
        return disciplina;
    }

    @Transactional
    public Disciplina update(Long id, Disciplina disciplina) {
        Disciplina existingDisciplina = disciplinaRepository.findById(id);
        if (existingDisciplina != null) {
            existingDisciplina.setNome(disciplina.getNome());
            existingDisciplina.setCreditos(disciplina.getCreditos());
            existingDisciplina.setProfessor(disciplina.getProfessor());
            existingDisciplina.setSemestre(disciplina.getSemestre());
            return existingDisciplina;
        }
        return null;
    }

    @Transactional
    public void delete(Long id) {
        disciplinaRepository.deleteById(id);
    }
}