package com.test.service;

import com.test.entity.Usuario;
import com.test.repository.UsuarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@ApplicationScoped
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> findAll() {
        return usuarioRepository.listAll();
    }

    public Usuario findById(Long id) {
        return usuarioRepository.findById(id);
    }

    @Transactional
    public Usuario create(Usuario usuario) {
        usuarioRepository.persist(usuario);
        return usuario;
    }

    @Transactional
    public Usuario update(Long id, Usuario usuario) {
        Usuario existingUsuario = usuarioRepository.findById(id);
        if (existingUsuario != null) {
            existingUsuario.setNome(usuario.getNome());
            existingUsuario.setEmail(usuario.getEmail());
            existingUsuario.setPerfil(usuario.getPerfil());
            return existingUsuario;
        }
        return null;
    }

    @Transactional
    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }
}