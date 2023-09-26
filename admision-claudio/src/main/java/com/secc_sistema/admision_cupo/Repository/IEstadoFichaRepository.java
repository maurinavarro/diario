package com.secc_sistema.admision_cupo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.secc_sistema.admision_cupo.Model_Entities.estadoFicha;

public interface IEstadoFichaRepository extends JpaRepository<estadoFicha, Long>{
    
}
