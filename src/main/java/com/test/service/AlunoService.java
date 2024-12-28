package com.test.service;

import com.test.entity.Aluno;
import com.test.repository.AlunoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<Aluno> findAll() {
        return alunoRepository.listAll();
    }

    public Aluno findById(Long id) {
        return alunoRepository.findById(id);
    }

    @Transactional
    public Aluno create(Aluno aluno) {
        alunoRepository.persist(aluno);
        return aluno;
    }

    @Transactional
    public Aluno update(Long id, Aluno aluno) {
        Aluno existingAluno = alunoRepository.findById(id);
        if (existingAluno != null) {
            existingAluno.setNome(aluno.getNome());
            existingAluno.setCurso(aluno.getCurso());
            existingAluno.setEmail(aluno.getEmail());
            existingAluno.setAtivo(aluno.getAtivo());
            return existingAluno;
        }
        return null;
    }

    @Transactional
    public void delete(Long id) {
        alunoRepository.deleteById(id);
    }
}