package com.biolab.plataformadecursos.services;

import com.biolab.plataformadecursos.DTOs.AlunoDTO;
import com.biolab.plataformadecursos.entities.Aluno;
import com.biolab.plataformadecursos.repositories.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    //cadastrar aluno
    public String cadastrarAluno(AlunoDTO dto) {
        Aluno aluno = new Aluno();
        aluno.setNome(dto.getNome());
        aluno.setEmail(dto.getEmail());
        alunoRepository.save(aluno);
        return "Aluno criado com sucesso";
    }

    //buscar aluno por id
    public AlunoDTO buscarAlunoId(Long id) {
        Aluno aluno = alunoRepository.findById(id).orElseThrow();
        AlunoDTO dto = new AlunoDTO();
        dto.setId(aluno.getId());
        dto.setNome(aluno.getNome());
        dto.setEmail(aluno.getEmail());
        return dto;
    }

    //buscar por todos os alunos
    public List<Aluno> buscarTodosAlunos(){
        return alunoRepository.findAll();
    }

    //atuslizar o aluno
    public AlunoDTO atualizarAluno(Long id, AlunoDTO dto){
        Aluno aluno = alunoRepository.findById(id).orElseThrow();
        AlunoDTO a = new AlunoDTO();
        aluno.setNome(dto.getNome());
        aluno.setEmail(dto.getEmail());
        alunoRepository.save(aluno);
        a.setId(aluno.getId());
        a.setNome(aluno.getNome());
        a.setEmail(aluno.getEmail());
        return a;
    }

    //deletar o aluno
    public String deletarAluno(long id) {
        alunoRepository.deleteById(id);
        return "excluido com sucesso";
    }
}
