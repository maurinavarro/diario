package com.secc_sistema.admision_cupo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.secc_sistema.admision_cupo.Model_Entities.Fuerza;


public interface IFuerzaRepository extends JpaRepository<Fuerza, Long>{

    @Query("select f from Fuerza f Where f.nombre like %:criterio%  and f.activo = true")
    List<Fuerza> buscarPor(@Param("criterio") String criterio );

    @Query("select f from Fuerza f Where f.activo = true")
    List<Fuerza> buscarSoloHabilitados( );
          
}
