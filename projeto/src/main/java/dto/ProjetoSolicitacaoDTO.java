package dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjetoSolicitacaoDTO {
    @NotBlank
    private String nome;
    private String escola;
    private String objetivo;
    private String escopo;
    private String publicoAlvo;
    private LocalDate dataInicio;
}