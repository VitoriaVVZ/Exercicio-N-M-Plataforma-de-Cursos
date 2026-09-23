package com.biolab.plataformadecursos.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter //cria automaticamente metodo de leitura
@Setter //cria automatico o metodo de modificação
@NoArgsConstructor //construtor sem parametros
@AllArgsConstructor //construtor com todos parametros
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    @JsonIgnoreProperties("matriculas") //evita o looping
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    @JsonIgnoreProperties("matriculas") //evita o looping
    private Curso curso;
}
