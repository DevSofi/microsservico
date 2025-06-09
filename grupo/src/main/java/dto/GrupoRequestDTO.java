package dto;
import lombok.Data;

import java.util.List;

@Data
public class GrupoRequestDTO {
    private String nome;
    private List<Long> alunoIds;
}