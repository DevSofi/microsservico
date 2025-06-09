package model;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "grupos")
@Data
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @ElementCollection
    @CollectionTable(name = "grupo_alunos", joinColumns = @JoinColumn(name = "grupo_id"))
    @Column(name = "aluno_id")
    private List<Long> alunoIds;
}