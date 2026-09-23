package com.biolab.plataformadecursos.controllers;

import com.biolab.plataformadecursos.DTOs.CursoDTO;
import com.biolab.plataformadecursos.services.CursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("curso")
public class CursoController {

    private final CursoService service;

    public CursoController(CursoService service) {
        this.service = service;
    }

    @PostMapping //cria o curso
    public ResponseEntity<?> criarCurso(@RequestBody CursoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criarCurso(dto));
    }

    @GetMapping("/{id}") //busca o curso pelo id
    public ResponseEntity<?> buscarCursoId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarCursoId(id));
    }

    @GetMapping //busca por todos os cursos
    public ResponseEntity<?> buscarTodosCursos() {
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarTodosCursos());
    }

    @PutMapping("/{id}") //atualiza o curso
    public ResponseEntity<?> atualizarCurso(@PathVariable Long id, @RequestBody CursoDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(service.atualizarCurso(id, dto));
    }

    @DeleteMapping("/{id}") //deleta o curso
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.deletarCurso(id));
    }
}
