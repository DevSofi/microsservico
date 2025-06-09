package dto;

import model.enums.StatusProjeto;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ProjetoDTO {
    private Long id;
    private String nome;
    private String escola;
    private String objetivo;
    private String escopo;
    private String publicoAlvo;
    private LocalDate dataInicio;
    private StatusProjeto statusProjeto;
    private GrupoDTO grupo;
}
