package controller;
import dto.UsuarioDTO;
import dto.UsuarioRequestDTO;
import dto.UsuarioResponseDTO;
import model.enums.TipoUsuario;
import service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listarPorPerfil(@RequestParam TipoUsuario tipoUsuario) {
        return ResponseEntity.ok(usuarioService.listarPorPerfil(tipoUsuario));
    }

    @PostMapping("/cadastro")
    public ResponseEntity<UsuarioResponseDTO> cadastrar(@RequestBody UsuarioRequestDTO dto) {
        return ResponseEntity.ok(usuarioService.cadastrar(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioResponseDTO> login(@RequestBody UsuarioRequestDTO dto) {
        return ResponseEntity.ok(usuarioService.autenticar(dto));
    }

    @PostMapping("/cadastro/professor")
    public ResponseEntity<UsuarioResponseDTO> cadastrarProfessor(@RequestBody UsuarioRequestDTO dto) {
        dto.setTipoUsuario(TipoUsuario.PROFESSOR);
        return ResponseEntity.ok(usuarioService.cadastrar(dto));
    }

}
