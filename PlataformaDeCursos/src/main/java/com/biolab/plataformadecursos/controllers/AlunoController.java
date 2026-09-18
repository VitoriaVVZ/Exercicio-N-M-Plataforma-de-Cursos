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

    @PostMapping
    public ResponseEntity<?> cadastrarAluno(@RequestBody AlunoDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrarAluno(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarAlunoId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarAlunoId(id));
    }

    @GetMapping
    public ResponseEntity<?> buscarTodosAlunos(){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarTodosAlunos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarAluno(@PathVariable Long id, @RequestBody AlunoDTO dto){
        return ResponseEntity.status(HttpStatus.OK).body(service.atualizarAluno(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.deletarAluno(id));
    }
}