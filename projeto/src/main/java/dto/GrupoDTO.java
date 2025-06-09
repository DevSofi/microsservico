package dto;

import java.util.List;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class GrupoDTO {
    private Long id;
    private String nome;
    private List<ProjetoDTO> projetos;
}