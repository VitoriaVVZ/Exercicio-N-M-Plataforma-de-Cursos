package com.biolab.plataformadecursos.repositories;

import org.springframework.stereotype.Repository;
import com.biolab.plataformadecursos.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
}
