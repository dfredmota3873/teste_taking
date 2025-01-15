package com.test.service;

import com.test.entity.Curso;
import com.test.entity.Usuario;
import com.test.enums.EPerfil;
import com.test.exception.TestApplicationException;
import com.test.repository.CursoRepository;
import com.test.repository.UsuarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

import java.util.List;

@ApplicationScoped
public class CursoService {

    private final CursoRepository cursoRepository;

    private final UsuarioRepository usuarioRepository;

    public CursoService(CursoRepository cursoRepository,
                        UsuarioRepository usuarioRepository) {
        this.cursoRepository = cursoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<Curso> findAll() {
        return cursoRepository.listAll();
    }

    public Curso findById(Long id) {
        return cursoRepository.findById(id);
    }

    @Transactional
    public Curso create(Curso curso) throws TestApplicationException {

        Usuario usuario = this.usuarioRepository.findByIdOptional(curso.getCoordenador().getId())
                .orElseThrow(() -> new TestApplicationException("O usuário com id : " + curso.getCoordenador().getId() + " nao existe."));

        if (!usuario.getPerfil().equals(EPerfil.COORDENADOR)) {
            throw new TestApplicationException("O perfil deste usuário não é coordenador!");
        }

        curso.setCoordenador(usuario);

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