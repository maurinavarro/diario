package com.secc_sistema.admision_cupo.Service;

import java.util.List;


import com.secc_sistema.admision_cupo.Model_Entities.Unidad;

public interface IUnidadService {

    public List<Unidad> buscarTodo();

    public List<Unidad> buscarPor(String criterio);

    public Unidad buscarPorId(Long id);
    
    public void guardar(Unidad unidad);
    
}
