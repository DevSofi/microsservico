package dto;
import lombok.Data;

@Data
public class AlunoRequestDTO {
    private Long alunoId;
    private String nome;
    private String matricula;
    private String email;
}