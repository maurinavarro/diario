package com.secc_sistema.admision_cupo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.secc_sistema.admision_cupo.Model_Entities.Permiso;

public interface IPermisoRepository extends JpaRepository<Permiso, Long> {
    
}
