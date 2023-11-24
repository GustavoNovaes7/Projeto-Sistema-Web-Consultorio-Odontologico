package com.senac.PIetapa7e9.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Date;
import lombok.Data;

@Data
@Entity
@Table(name = "auxiliares")
public class AuxiliarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String nome;

    @NotNull
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
}
