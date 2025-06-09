package  controller;

import dto.AlunoRequestDTO;
import dto.AlunoResponseDTO;
import service.AlunoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
@RequiredArgsConstructor
public class AlunoController {

    private final AlunoService alunoService;

    @PostMapping("/cadastrar")
    public ResponseEntity<AlunoResponseDTO> cadastrarAluno(@RequestBody AlunoRequestDTO dto) {
        AlunoResponseDTO response = alunoService.cadastrarAluno(dto);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<AlunoResponseDTO>> listarTodosAlunos() {
        List<AlunoResponseDTO> alunos = alunoService.listarTodosAlunos();
        return ResponseEntity.ok(alunos);
    }
}
