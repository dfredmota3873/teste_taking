package com.test.service;

import com.test.entity.Perfil;
import com.test.repository.PerfilRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class PerfilService {

    private final PerfilRepository perfilRepository;

    public PerfilService(PerfilRepository perfilRepository) {
        this.perfilRepository = perfilRepository;
    }

    public List<Perfil> findAll() {
        return perfilRepository.listAll();
    }

    public Perfil findById(Long id) {
        return perfilRepository.findById(id);
    }

    @Transactional
    public Perfil create(Perfil perfil) {
        perfilRepository.persist(perfil);
        return perfil;
    }

    @Transactional
    public Perfil update(Long id, Perfil perfil) {
        Perfil existingPerfil = perfilRepository.findById(id);
        if (existingPerfil != null) {
            existingPerfil.setNome(perfil.getNome());
            existingPerfil.setAtivo(perfil.getAtivo());
            existingPerfil.setIsAdmin(perfil.getIsAdmin());
            return existingPerfil;
        }
        return null;
    }

    @Transactional
    public void delete(Long id) {
        perfilRepository.deleteById(id);
    }
}