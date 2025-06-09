package dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import model.enums.StatusProjeto;

@Data
public class AtualizarStatusProjetoDTO {
    @NotNull
    private StatusProjeto novoStatus;
}