package com.senac.PIetapa7e9.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@Entity
@Table(name = "atendimentos")
public class AtendimentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Este campo é obrigatório.")
    private LocalDateTime data_hora;

    @NotNull(message = "Este campo é obrigatório.")
    @ManyToOne
    private EspecialidadeEntity especialidade;

    @NotNull(message = "Este campo é obrigatório.")
    @ManyToOne
    private DentistaEntity dentista_marcado;

    @ManyToOne
    private DentistaEntity dentista_atendeu;

    @ManyToOne
    private AuxiliarEntity auxiliar;
    
    @ManyToOne
    private PacienteEntity paciente;
    
    @ManyToOne
    private ConvenioEntity convenio;
    
    private String numero_convenio;
}
