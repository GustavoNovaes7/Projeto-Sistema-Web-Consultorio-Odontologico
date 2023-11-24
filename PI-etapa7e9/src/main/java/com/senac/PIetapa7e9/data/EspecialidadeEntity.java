package com.senac.PIetapa7e9.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "especialidades")
public class EspecialidadeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String nome;

    @ManyToMany
    @JoinTable(
        name = "dentista_especialidade",
        joinColumns = @JoinColumn(name = "especialidade_id"),
        inverseJoinColumns = @JoinColumn(name = "dentista_id")
    )
    private List<DentistaEntity> dentistas;
}
