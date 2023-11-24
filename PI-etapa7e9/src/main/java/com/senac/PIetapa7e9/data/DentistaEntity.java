package com.senac.PIetapa7e9.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
@Table(name = "dentistas")
public class DentistaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String nome;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotBlank
    private Date nascimento;

    @NotBlank
    private String cpf;

    @NotBlank
    private String uf_cro;

    @NotBlank
    private String cro;

    @NotBlank
    private String endereco;

    @NotBlank
    private String telefone;

    @NotBlank
    private String email;
    
    @ManyToMany(mappedBy = "dentistas")
    private List<EspecialidadeEntity> especialidades;
}
