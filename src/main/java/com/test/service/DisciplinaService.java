package com.test.service;

import com.test.entity.Disciplina;
import com.test.entity.Semestre;
import com.test.entity.Usuario;
import com.test.exception.TestApplicationException;
import com.test.repository.DisciplinaRepository;
import com.test.repository.SemestreRepository;
import com.test.repository.UsuarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class DisciplinaService {

    private final DisciplinaRepository disciplinaRepository;

    private final UsuarioRepository usuarioRepository;

    private final SemestreRepository semestreRepository;

    public DisciplinaService(DisciplinaRepository disciplinaRepository,
                             UsuarioRepository usuarioRepository,
                             SemestreRepository semestreRepository) {
        this.disciplinaRepository = disciplinaRepository;
        this.usuarioRepository = usuarioRepository;
        this.semestreRepository = semestreRepository;
    }

    public List<Disciplina> findAll() {
        return disciplinaRepository.listAll();
    }

    public Disciplina findById(Long id) {
        return disciplinaRepository.findById(id);
    }

    @Transactional
    public Disciplina create(Disciplina disciplina) throws TestApplicationException {

        Usuario usuario = this.usuarioRepository.findByIdOptional(disciplina.getProfessor().getId())
                .orElseThrow(() -> new TestApplicationException("O professor com id : " + disciplina.getProfessor().getId() + " nao existe."));

        disciplina.setProfessor(usuario);

        Semestre semestre = this.semestreRepository.findByIdOptional(disciplina.getSemestre().getId())
                .orElseThrow(() -> new TestApplicationException("O semestre com id : " + disciplina.getSemestre().getId() + " nao existe."));

        disciplina.setSemestre(semestre);

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