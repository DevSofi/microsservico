package dto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AlunoResponseDTO {
    private Long id;
    private String nome;
    private String matricula;
}
