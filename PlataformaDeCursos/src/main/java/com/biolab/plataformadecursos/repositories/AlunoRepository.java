package com.biolab.plataformadecursos.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.biolab.plataformadecursos.entities.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}