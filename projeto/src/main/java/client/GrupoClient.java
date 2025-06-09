package client;

import dto.GrupoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "grupo", path = "/grupo")
public interface GrupoClient {

    @GetMapping("/{id}")
    GrupoDTO getGrupoById(@PathVariable Long id);
}