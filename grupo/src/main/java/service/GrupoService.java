package service;

import dto.GrupoRequestDTO;
import dto.GrupoResponseDTO;
import model.Grupo;
import repository.GrupoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GrupoService {

    private final GrupoRepository grupoRepository;

    public GrupoResponseDTO criarGrupo(GrupoRequestDTO dto) {
        Grupo grupo = new Grupo();
        grupo.setNome(dto.getNome());
        grupo.setAlunoIds(dto.getAlunoIds());

        Grupo salvo = grupoRepository.save(grupo);

        return new GrupoResponseDTO(salvo.getId(), salvo.getNome(), salvo.getAlunoIds());
    }

    public List<GrupoResponseDTO> listarGrupos() {
        return grupoRepository.findAll().stream()
                .map(g -> new GrupoResponseDTO(g.getId(), g.getNome(), g.getAlunoIds()))
                .toList();
    }
}
