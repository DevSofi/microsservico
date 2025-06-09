package dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class ProjetoAtribuirGrupoDTO {
    @NotNull
    private Long grupoId;
}
