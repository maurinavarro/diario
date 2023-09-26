package com.secc_sistema.admision_cupo.Service;
import java.util.List;

import com.secc_sistema.admision_cupo.Model_Entities.Permiso;

public interface IPermisoService {
    
    public List<Permiso> buscarTodo();

    public List<Permiso> buscarPor(String criterio);

    public Permiso buscarPorId(Long id);
    
    public void guardar(Permiso permiso);
}