package com.test.service;

import com.test.dto.request.CursoRequest;
import com.test.dto.response.CursoResponseDTO;
import com.test.entity.Curso;
import com.test.mappers.CursoMapper;
import com.test.repository.CursoRepository;
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

    public List<CursoResponseDTO> listar(){

        List<Curso> lista = this.cursoRepository.listAll();

        if(lista.isEmpty()){
            return Collections.emptyList();
        }
        return CursoMapper.toResponseList(lista);
    }

    @Transactional
    public CursoResponseDTO salvar(CursoRequest cursoRequest){

        Curso cursoEntity = CursoMapper.toEntity(cursoRequest);

        ProfessorEntity professor = professorRepository.findByIdOptional(cursoRequest.getProfessor()).orElseThrow(() ->
                new NotFoundException("Esse professor não existe"));

        cursoEntity.setProfessor(professor);

        this.cursoRepository.persist(cursoEntity);

        return CursoMapper.toResponse(cursoEntity);

    }

}
