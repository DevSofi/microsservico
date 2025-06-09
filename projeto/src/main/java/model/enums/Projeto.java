package model.enums;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "projetos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String escola;
    private String objetivo;
    private String escopo;

    @Column(name = "publico_alvo")
    private String publicoAlvo;

    @Column(name = "data_inicio")
    private LocalDate dataInicio;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_projeto", nullable = false)
    private StatusProjeto statusProjeto;

    @Column(name = "grupo_id")
    private Long grupoId;
}