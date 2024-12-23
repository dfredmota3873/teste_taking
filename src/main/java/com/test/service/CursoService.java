package com.test.service;

import com.test.dto.request.CursoRequest;
import com.test.dto.response.CursoResponse;
import com.test.dto.response.ProfessorResponse;
import com.test.entity.CursoEntity;
import com.test.entity.ProfessorEntity;
import com.test.mappers.CursoMapper;
import com.test.mappers.ProfessorMapper;
import com.test.repository.CursoRepository;
import com.test.repository.ProfessorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;

@Slf4j
@ApplicationScoped
public class CursoService {

    private final CursoRepository cursoRepository;
    private final ProfessorRepository professorRepository;

    @Inject
    public CursoService(CursoRepository cursoRepository, ProfessorRepository professorRepository) {
        this.cursoRepository = cursoRepository;
        this.professorRepository = professorRepository;
    }

    public List<CursoResponse> listar(){

        List<CursoEntity> lista = this.cursoRepository.listAll();

        if(lista.isEmpty()){
            return Collections.emptyList();
        }
        return CursoMapper.toResponseList(lista);
    }

    @Transactional
    public CursoResponse salvar(CursoRequest cursoRequest){

        CursoEntity cursoEntity = CursoMapper.toEntity(cursoRequest);

        ProfessorEntity professor = professorRepository.findByIdOptional(cursoRequest.getProfessor()).orElseThrow(() ->
                new NotFoundException("Esse professor não existe"));

        cursoEntity.setProfessor(professor);

        this.cursoRepository.persist(cursoEntity);

        return CursoMapper.toResponse(cursoEntity);

    }

}
