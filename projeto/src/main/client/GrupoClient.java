package client;

import model.Grupo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GrupoClient {

    @Value("${ms.grupos.url}")
    private String grupoServiceUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public Grupo getGrupoById(Long id) {
        ResponseEntity<Grupo> response = restTemplate.getForEntity(grupoServiceUrl + "/grupos/" + id, Grupo.class);
        return response.getBody();
    }
}