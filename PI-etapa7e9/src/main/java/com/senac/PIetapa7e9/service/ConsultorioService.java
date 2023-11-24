package com.senac.PIetapa7e9.service;

import com.senac.PIetapa7e9.data.AtendimentoEntity;
import com.senac.PIetapa7e9.data.AtendimentoRepository;
import com.senac.PIetapa7e9.data.AuxiliarRepository;
import com.senac.PIetapa7e9.data.ConvenioEntity;
import com.senac.PIetapa7e9.data.ConvenioRepository;
import com.senac.PIetapa7e9.data.DentistaEntity;
import com.senac.PIetapa7e9.data.DentistaRepository;
import com.senac.PIetapa7e9.data.EspecialidadeEntity;
import com.senac.PIetapa7e9.data.EspecialidadeRepository;
import com.senac.PIetapa7e9.data.PacienteEntity;
import com.senac.PIetapa7e9.data.PacienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultorioService {

    @Autowired
    AtendimentoRepository atendimentoRepository;
    @Autowired
    PacienteRepository pacienteRepository;
    @Autowired
    AuxiliarRepository auxiliarRepository;
    @Autowired
    DentistaRepository dentistaRepository;
    @Autowired
    ConvenioRepository convenioRepository;
    @Autowired
    EspecialidadeRepository especialidadeRepository;

    //Métodos para Pacientes
    public PacienteEntity getPacienteId(Integer pacienteId) {
        return pacienteRepository.findById(pacienteId).orElse(null);
    }

    public PacienteEntity getPacienteUsuario(String pacienteLogin) {
        return pacienteRepository.findByLogin(pacienteLogin);
    }

    public PacienteEntity criarPaciente(PacienteEntity paciente) {
        paciente.setId(null);
        pacienteRepository.save(paciente);
        return paciente;
    }
    
    public List<PacienteEntity> listarPacientes(){
        return pacienteRepository.findAll();
    }

    public PacienteEntity atualizarPaciente(Integer pacienteId, PacienteEntity pacienteRequest) {
        PacienteEntity paciente = getPacienteId(pacienteId);

        paciente.setSenha(pacienteRequest.getSenha());
        paciente.setNome(pacienteRequest.getNome());
        paciente.setNascimento(pacienteRequest.getNascimento());
        paciente.setCpf(pacienteRequest.getCpf());
        paciente.setRg(pacienteRequest.getRg());
        paciente.setEndereco(pacienteRequest.getEndereco());
        paciente.setTelefone(pacienteRequest.getTelefone());
        paciente.setEmail(pacienteRequest.getEmail());
        paciente.setConvenio(pacienteRequest.getConvenio());
        pacienteRepository.save(paciente);
        return paciente;
    }

    public ConvenioEntity getConvenioId(Integer convenioId) {
        return convenioRepository.findById(convenioId).orElse(null);
    }

    public List<ConvenioEntity> listarConvenios() {
        return convenioRepository.findAll();
    }

    public List<ConvenioEntity> listarConveniosSemEscolhido(Integer pacienteId) {
        List<ConvenioEntity> lista = convenioRepository.findAll();
        PacienteEntity paciente = getPacienteId(pacienteId);
        if (paciente.getConvenio() != null) {
            ConvenioEntity convenioEscolhido = getConvenioId(paciente.getConvenio().getId());
            lista.remove(convenioEscolhido);
        }
        return lista;
    }

    //Métodos para Atendimentos/Consultas
    public AtendimentoEntity getAtendimentoId(Integer atendimentoId) {
        return atendimentoRepository.findById(atendimentoId).orElse(null);
    }

    public AtendimentoEntity criarAtendimento(AtendimentoEntity atendimento) {
        atendimento.setId(null);
        atendimentoRepository.save(atendimento);
        return atendimento;
    }

    public List<AtendimentoEntity> listarAtendimentos(Integer pacienteId) {
        return atendimentoRepository.findByPacienteId(pacienteId);
    }
    
    public List<EspecialidadeEntity> listarEspecialidades(){
        return especialidadeRepository.findAll();
    }
    
    public List<DentistaEntity> listarDentistasPorEspecialidade(){
        return dentistaRepository.findAll();
    }

    public void deletarAtendimento(Integer atendimentoId) {
        AtendimentoEntity atendimento = getAtendimentoId(atendimentoId);
        atendimentoRepository.deleteById(atendimento.getId());
    }
}
