package client;

import dto.AlunoResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class AlunoClient {

    private final RestTemplate restTemplate;

    @Value("${alunos.url}")
    private String alunoServiceUrl;

    public AlunoResponseDTO buscarAlunoPorId(Long id) {
        ResponseEntity<AlunoResponseDTO> response =
                restTemplate.getForEntity(alunoServiceUrl + "/alunos/" + id, AlunoResponseDTO.class);
        return response.getBody();
    }
}
