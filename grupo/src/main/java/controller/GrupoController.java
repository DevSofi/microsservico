package controller;

import dto.GrupoRequestDTO;
import dto.GrupoResponseDTO;
import service.GrupoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grupos")
@RequiredArgsConstructor
public class GrupoController {

    private final GrupoService grupoService;

    @PostMapping("/criar")
    public ResponseEntity<GrupoResponseDTO> criarGrupo(@RequestBody GrupoRequestDTO dto) {
        GrupoResponseDTO response = grupoService.criarGrupo(dto);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<GrupoResponseDTO>> listarGrupos() {
        return ResponseEntity.ok(grupoService.listarGrupos());
    }
}