package com.secc_sistema.admision_cupo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.secc_sistema.admision_cupo.Model_Entities.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByNombreOrEmail(String nombre, String email);

    Usuario findByNombre(String nombreUsuario);
    
    @Query("select u from Usuario u Where u.nombre like %:criterio% or u.email like %:criterio% and u.activo = true")
    List<Usuario> buscarPor(@Param("criterio") String criterio );

    @Query("select u from Usuario u Where u.activo = true")
    List<Usuario> buscarSoloHabilitados( );
    
}
