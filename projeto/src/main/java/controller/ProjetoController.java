package controller;


import dto.*;
import service.ProjetoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projetos")
@RequiredArgsConstructor
public class ProjetoController {

    private final ProjetoService projetoService;

    @GetMapping
    public ResponseEntity<List<ProjetoResponseDTO>> listarTodosProjetos() {
        return ResponseEntity.ok(projetoService.listarTodosProjetos());
    }

    @PostMapping("/solicitar")
    public ResponseEntity<ProjetoResponseDTO> solicitarProjeto(@RequestBody ProjetoSolicitacaoDTO dto) {
        return ResponseEntity.ok(projetoService.solicitarSemGrupo(dto));
    }

    @GetMapping("/grupo/{id}")
    public ResponseEntity<List<ProjetoResponseDTO>> listarProjetosDoGrupo(@PathVariable Long id) {
        return ResponseEntity.ok(projetoService.listarProjetosPorGrupo(id));
    }

    @PutMapping("/{id}/atribuir-grupo")
    public ResponseEntity<String> atribuirGrupo(@PathVariable Long id, @RequestBody ProjetoAtribuirGrupoDTO dto) {
        projetoService.atribuirGrupo(id, dto.getGrupoId());
        return ResponseEntity.ok("Grupo atribuído com sucesso.");
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<String> atualizarStatus(@PathVariable Long id, @RequestBody AtualizarStatusProjetoDTO dto) {
        projetoService.atualizarStatus(id, dto);
        return ResponseEntity.ok("Status atualizado para: " + dto.getNovoStatus());
    }

    @PutMapping("/{id}/confirmar-recebimento")
    public ResponseEntity<String> confirmarRecebimento(@PathVariable Long id) {
        projetoService.confirmarRecebimento(id);
        return ResponseEntity.ok("Projeto marcado como recebido.");
    }
}