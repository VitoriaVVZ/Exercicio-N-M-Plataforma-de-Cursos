package com.biolab.plataformadecursos.services;

import com.biolab.plataformadecursos.DTOs.MatriculaDTO;
import com.biolab.plataformadecursos.entities.Aluno;
import com.biolab.plataformadecursos.entities.Curso;
import com.biolab.plataformadecursos.entities.Matricula;
import com.biolab.plataformadecursos.repositories.AlunoRepository;
import com.biolab.plataformadecursos.repositories.CursoRepository;
import com.biolab.plataformadecursos.repositories.MatriculaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaService {

    private final MatriculaRepository matriculaRepository;
    private final AlunoRepository alunoRepository;
    private final CursoRepository cursoRepository;

    public MatriculaService(MatriculaRepository matriculaRepository, AlunoRepository alunoRepository, CursoRepository cursoRepository) {
        this.matriculaRepository = matriculaRepository;
        this.alunoRepository = alunoRepository;
        this.cursoRepository = cursoRepository;
    }

    //criar a matricula
    public String matricular(Long alunoId, Long cursoId) {
        Aluno aluno = alunoRepository.findById(alunoId).orElseThrow();
        Curso curso = cursoRepository.findById(cursoId).orElseThrow();

        Matricula matricula = new Matricula();
        matricula.setAluno(aluno);
        matricula.setCurso(curso);

        matriculaRepository.save(matricula);
        return "Aluno matriculado no curso com sucesso!!";
    }

    //deletar a matricula
    public String removerMatricula(Long id) {
        Matricula matricula = matriculaRepository.findById(id).orElseThrow();
        matriculaRepository.deleteById(matricula.getId());
        return "Matricula removida com sucesso!!";
    }

    //buscar todas matriculas dos alunos
    public List<Matricula> buscarMatriculasDoAluno(Long alunoId) {
        Aluno aluno = alunoRepository.findById(alunoId).orElseThrow();
        return aluno.getMatriculas();
    }

    //buscar todas as matriculas do curso
    public List<Matricula> buscarMatriculasDoCurso(Long cursoId) {
        Curso curso = cursoRepository.findById(cursoId).orElseThrow();
        return curso.getMatriculas();
    }
}
