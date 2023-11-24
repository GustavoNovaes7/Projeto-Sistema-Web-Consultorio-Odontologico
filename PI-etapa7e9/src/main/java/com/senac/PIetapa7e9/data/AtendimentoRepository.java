package com.senac.PIetapa7e9.data;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AtendimentoRepository extends JpaRepository<AtendimentoEntity, Integer> {
    @Query(value = "SELECT * FROM atendimentos WHERE paciente_id = ?", nativeQuery = true)
    List<AtendimentoEntity> findByPacienteId(Integer pacienteId);
}
