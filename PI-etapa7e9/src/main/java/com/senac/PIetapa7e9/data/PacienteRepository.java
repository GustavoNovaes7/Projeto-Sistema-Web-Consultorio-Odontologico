package com.senac.PIetapa7e9.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<PacienteEntity, Integer> {
    @Query(value = "SELECT * FROM pacientes WHERE login = ?", nativeQuery = true)
    PacienteEntity findByLogin(String login);
}
