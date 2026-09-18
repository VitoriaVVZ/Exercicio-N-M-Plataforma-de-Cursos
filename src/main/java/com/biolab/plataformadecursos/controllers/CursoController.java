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

    @PostMapping
    public ResponseEntity<?> criarCurso(@RequestBody CursoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criarCurso(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarCursoId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarCursoId(id));
    }

    @GetMapping
    public ResponseEntity<?> buscarTodosCursos() {
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarTodosCursos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarCurso(@PathVariable Long id, @RequestBody CursoDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(service.atualizarCurso(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.deletarCurso(id));
    }
}
