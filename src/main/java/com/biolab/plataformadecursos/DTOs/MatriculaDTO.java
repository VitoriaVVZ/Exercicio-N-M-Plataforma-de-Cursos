package com.biolab.plataformadecursos.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatriculaDTO {

    private Long id;
    private Long alunoId;
    private Long cursoId;
}