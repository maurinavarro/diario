package com.secc_sistema.admision_cupo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.secc_sistema.admision_cupo.Model_Entities.Detenido;

public interface IDetenidoRepository extends JpaRepository<Detenido, Long>{

    @Query("select d from Detenido d Where d.nombreApellido like %:criterio% or d.dni like %:criterio% and d.activo = true")
    List<Detenido> buscarPor(@Param("criterio") String criterio );

    @Query("select d from Detenido d Where d.activo = true")
    List<Detenido> buscarSoloHabilitados( );
    
}
