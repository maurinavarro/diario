package com.secc_sistema.admision_cupo.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.secc_sistema.admision_cupo.Model_Entities.Detenido;
import com.secc_sistema.admision_cupo.Model_Entities.Solicitudes;


public interface ISolicitudesRepository extends JpaRepository<Solicitudes, Long>{

    Solicitudes findByDetenido(Detenido detenido);
 
       
}
