package service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import client.GrupoClient;
import dto.AtualizarStatusProjetoDTO;
import dto.GrupoDTO;
import dto.ProjetoResponseDTO;
import dto.ProjetoSolicitacaoDTO;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import model.enums.Projeto;
import model.enums.StatusProjeto;
import repository.ProjetoRepository;

@Service
@RequiredArgsConstructor
public class ProjetoService {

    private final ProjetoRepository ProjetoRepository;
    private final GrupoClient grupoClient;

    public ProjetoResponseDTO solicitarSemGrupo(ProjetoSolicitacaoDTO dto) {
        Projeto projeto = Projeto.builder()
                .nome(dto.getNome())
                .escola(dto.getEscola())
                .objetivo(dto.getObjetivo())
                .escopo(dto.getEscopo())
                .publicoAlvo(dto.getPublicoAlvo())
                .dataInicio(dto.getDataInicio())
                .statusProjeto(StatusProjeto.PENDENTE)
                .build();

        Projeto salvo = ProjetoRepository.save(projeto);
        
        return new ProjetoResponseDTO(salvo.getId(), salvo.getNome(), salvo.getEscola(), salvo.getObjetivo(),
                salvo.getEscopo(), salvo.getPublicoAlvo(), salvo.getDataInicio(), salvo.getStatusProjeto(), null, null);
    }

    public List<ProjetoResponseDTO> listarProjetosPorGrupo(Long grupoId) {
        GrupoDTO grupo = grupoClient.getGrupoById(grupoId);
        if (grupo == null) throw new EntityNotFoundException("Grupo não encontrado");

        return grupo.getProjetos().stream().map(projeto -> new ProjetoResponseDTO(
                projeto.getId(), projeto.getNome(), projeto.getEscola(), projeto.getObjetivo(),
                projeto.getEscopo(), projeto.getPublicoAlvo(), projeto.getDataInicio(), projeto.getStatusProjeto(),
                grupo.getId(), grupo.getNome()
        )).collect(Collectors.toList());
    }

    public List<ProjetoResponseDTO> listarTodosProjetos() {
        return ProjetoRepository.findAll().stream()
                .map(proj -> {
                    GrupoDTO grupo = grupoClient.getGrupoById(proj.getGrupoId());
                    return new ProjetoResponseDTO(proj.getId(), proj.getNome(), proj.getEscola(), proj.getObjetivo(),
                            proj.getEscopo(), proj.getPublicoAlvo(), proj.getDataInicio(), proj.getStatusProjeto(),
                            grupo != null ? grupo.getId() : null,
                            grupo != null ? grupo.getNome() : null);
                }).collect(Collectors.toList());
    }

    @Transactional
    public void atribuirGrupo(Long projetoId, Long grupoId) {
        Projeto projeto = ProjetoRepository.findById(projetoId)
                .orElseThrow(() -> new EntityNotFoundException("Projeto não encontrado"));

        projeto.setGrupoId(grupoId);
        ProjetoRepository.save(projeto);
    }

    @Transactional
    public void atualizarStatus(Long id, AtualizarStatusProjetoDTO dto) {
        Projeto projeto = ProjetoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Projeto não encontrado"));
        projeto.setStatusProjeto(dto.getNovoStatus());
        ProjetoRepository.save(projeto);
    }

    @Transactional
    public void confirmarRecebimento(Long id) {
        Projeto projeto = ProjetoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Projeto não encontrado"));
        projeto.setStatusProjeto(StatusProjeto.RECEBIDO);
        ProjetoRepository.save(projeto);
    }
}