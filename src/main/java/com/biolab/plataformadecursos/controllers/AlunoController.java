package com.biolab.plataformadecursos.controllers;

import com.biolab.plataformadecursos.DTOs.AlunoDTO;
import com.biolab.plataformadecursos.services.AlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("aluno")
public class AlunoController {

    private final AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }

    @PostMapping //cadastra o aluno
    public ResponseEntity<?> cadastrarAluno(@RequestBody AlunoDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrarAluno(dto));
    }

    @GetMapping("/{id}") //busca o aluno pelo id
    public ResponseEntity<?> buscarAlunoId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarAlunoId(id));
    }

    @GetMapping //busca por todos os alunos
    public ResponseEntity<?> buscarTodosAlunos(){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarTodosAlunos());
    }

    @PutMapping("/{id}") //atualiza as infromações do aluno
    public ResponseEntity<?> atualizarAluno(@PathVariable Long id, @RequestBody AlunoDTO dto){
        return ResponseEntity.status(HttpStatus.OK).body(service.atualizarAluno(id, dto));
    }

    @DeleteMapping("/{id}") //deleta o aluno
    public ResponseEntity<?> delete(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.deletarAluno(id));
    }
}
