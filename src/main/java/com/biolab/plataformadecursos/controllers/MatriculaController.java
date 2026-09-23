package com.biolab.plataformadecursos.controllers;

import com.biolab.plataformadecursos.DTOs.MatriculaDTO;
import com.biolab.plataformadecursos.entities.Matricula;
import com.biolab.plataformadecursos.services.MatriculaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matricula")
public class MatriculaController {

    private final MatriculaService matriculaService;

    public MatriculaController(MatriculaService matriculaService) {
        this.matriculaService = matriculaService;
    }

    @PostMapping //cria a matricula
    public ResponseEntity<String> matricular(@RequestBody MatriculaDTO dto) {
        String resposta = matriculaService.matricular(dto.getAlunoId(), dto.getCursoId());
        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }

    @DeleteMapping("/{id}") //deleta a matricula
    public ResponseEntity<String> removerMatricula(@PathVariable Long id) {
        String resposta = matriculaService.removerMatricula(id);
        return ResponseEntity.ok(resposta);
    }

    @GetMapping("/aluno/{alunoId}") //mostra a matricula do aluno
    public ResponseEntity<List<Matricula>> buscarMatriculasDoAluno(@PathVariable Long alunoId) {
        List<Matricula> matriculas = matriculaService.buscarMatriculasDoAluno(alunoId);
        return ResponseEntity.ok(matriculas);
    }

    @GetMapping("/curso/{cursoId}") //mostra o curso onde o aluno foi matriculado
    public ResponseEntity<List<Matricula>> buscarMatriculasDoCurso(@PathVariable Long cursoId) {
        List<Matricula> matriculas = matriculaService.buscarMatriculasDoCurso(cursoId);
        return ResponseEntity.ok(matriculas);
    }
}
