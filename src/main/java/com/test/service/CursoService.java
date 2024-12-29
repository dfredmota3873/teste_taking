package com.test.service;

import com.test.entity.Curso;
import com.test.repository.CursoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public List<Curso> findAll() {
        return cursoRepository.listAll();
    }

    public Curso findById(Long id) {
        return cursoRepository.findById(id);
    }

    @Transactional
    public Curso create(Curso curso) {
        cursoRepository.persist(curso);
        return curso;
    }

    @Transactional
    public Curso update(Long id, Curso curso) {
        Curso existingCurso = cursoRepository.findById(id);
        if (existingCurso != null) {
            existingCurso.setNome(curso.getNome());
            existingCurso.setDescricao(curso.getDescricao());
            existingCurso.setAtivo(curso.getAtivo());
            existingCurso.setCoordenador(curso.getCoordenador());
            return existingCurso;
        }
        return null;
    }

    @Transactional
    public boolean delete(Long id) {
        cursoRepository.deleteById(id);
        return true;
    }
}