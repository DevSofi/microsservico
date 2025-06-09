package service;

import java.util.List;

import org.springframework.stereotype.Service;

import dto.AlunoRequestDTO;

import dto.AlunoResponseDTO;
import lombok.RequiredArgsConstructor;
import model.Aluno;
import repository.AlunoRepository;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoResponseDTO cadastrarAluno(AlunoRequestDTO dto) {
        Aluno aluno = new Aluno();
        aluno.setNome(dto.getNome());
        aluno.setMatricula(dto.getMatricula());

        Aluno salvo = alunoRepository.save(aluno);

        return new AlunoResponseDTO(salvo.getId(), salvo.getNome(), salvo.getMatricula());
    }

    public List<AlunoResponseDTO> listarTodosAlunos() {
        return alunoRepository.findAll()
                .stream()
                .map(aluno -> new AlunoResponseDTO(
                        aluno.getId(),
                        aluno.getNome(),
                        aluno.getMatricula()
                ))
                .toList();
    }
}