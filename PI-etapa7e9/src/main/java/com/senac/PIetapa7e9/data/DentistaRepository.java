package com.senac.PIetapa7e9.data;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DentistaRepository extends JpaRepository<DentistaEntity, Integer>{

}
