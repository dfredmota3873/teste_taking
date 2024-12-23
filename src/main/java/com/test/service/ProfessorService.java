package com.test.service;

import com.test.dto.response.ProfessorResponse;
import com.test.entity.ProfessorEntity;
import com.test.mappers.ProfessorMapper;
import com.test.repository.ProfessorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;

@Slf4j
@ApplicationScoped
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    @Inject
    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public List<ProfessorResponse> listar(){

        List<ProfessorEntity> lista = this.professorRepository.listAll();

        if(lista.isEmpty()){
            return Collections.emptyList();
        }
        return ProfessorMapper.toResponseList(lista);
    }

}
