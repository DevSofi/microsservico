package dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ProjetoRequestDTO {
    @NotBlank
    private String nome;
    private String escola;
    private String objetivo;
    private String escopo;
    private String publicoAlvo;
    private LocalDate dataInicio;

    @NotNull
    private Long grupoId;
}