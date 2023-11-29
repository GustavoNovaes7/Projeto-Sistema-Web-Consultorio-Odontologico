package com.senac.PIetapa7e9.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Date;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Data
@Entity
@Table(name = "pacientes")
public class PacienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message="Este campo é obrigatório.")
    private String login;

    @NotBlank(message = "Este campo é obrigatório.")
    private String senha;

    @NotBlank(message = "Este campo é obrigatório.")
    private String nome;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Este campo é obrigatório.")
    private Date nascimento;

    @NotBlank(message = "Este campo é obrigatório.")
    private String cpf;

    @NotBlank(message = "Este campo é obrigatório.")
    private String rg;

    @NotBlank(message = "Este campo é obrigatório.")
    private String endereco;

    @NotBlank(message = "Este campo é obrigatório.")
    private String telefone;

    @NotBlank(message = "Este campo é obrigatório.")
    private String email;

    private String indicacao;

    private String nome_indicacao;

    @ManyToOne
    private ConvenioEntity convenio;
    
    public void setSenha(String senha) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(senha);
        this.senha = hashedPassword;
    }
}
