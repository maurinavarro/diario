package com.secc_sistema.admision_cupo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.secc_sistema.admision_cupo.Model_Entities.DatosJudiciales;

public interface IDatosJudicialesRepository extends JpaRepository<DatosJudiciales, Long> {
    
}
