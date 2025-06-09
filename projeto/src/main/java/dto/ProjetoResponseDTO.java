package dto;

import model.enums.StatusProjeto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ProjetoResponseDTO {
    public ProjetoResponseDTO(Long id2, String nome2, String escola2, String objetivo2, String escopo2,
			String publicoAlvo2, LocalDate dataInicio2, StatusProjeto statusProjeto2, Object grupoId2,
			Object nomeGrupo2) {
	}
	private Long id;
    private String nome;
    private String escola;
    private String objetivo;
    private String escopo;
    private String publicoAlvo;
    private LocalDate dataInicio;
    private StatusProjeto statusProjeto;
    private Long grupoId;
    private String nomeGrupo;
}