package com.biolab.plataformadecursos.services;

import com.biolab.plataformadecursos.DTOs.CursoDTO;
import com.biolab.plataformadecursos.entities.Curso;
import com.biolab.plataformadecursos.repositories.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public String criarCurso(CursoDTO dto) {
        Curso curso = new Curso();
        curso.setNome(dto.getNome());
        curso.setCargaHoraria(dto.getCargaHoraria());
        cursoRepository.save(curso);
        return "Curso criado com sucesso";
    }

    public CursoDTO buscarCursoId(Long id) {
        Curso curso = cursoRepository.findById(id).orElseThrow();
        CursoDTO dto = new CursoDTO();
        dto.setId(curso.getId());
        dto.setNome(curso.getNome());
        dto.setCargaHoraria(curso.getCargaHoraria());
        return dto;
    }

    public List<Curso> buscarTodosCursos() {
        return cursoRepository.findAll();
    }

    public String deletarCurso(long id) {
        cursoRepository.deleteById(id);
        return "excluido com sucesso";
    }

    public CursoDTO atualizarCurso(Long id, CursoDTO dto) {
        Curso curso = cursoRepository.findById(id).orElseThrow();
        CursoDTO c = new CursoDTO();
        curso.setNome(dto.getNome());
        curso.setCargaHoraria(dto.getCargaHoraria());
        cursoRepository.save(curso);
        c.setId(curso.getId());
        c.setNome(curso.getNome());
        c.setCargaHoraria(curso.getCargaHoraria());
        return c;
    }
}