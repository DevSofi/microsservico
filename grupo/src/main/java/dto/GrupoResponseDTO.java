package dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GrupoResponseDTO {
    private Long id;
    private String nome;
    private List<Long> alunoIds;
}