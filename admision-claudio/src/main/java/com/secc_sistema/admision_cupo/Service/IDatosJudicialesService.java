package com.secc_sistema.admision_cupo.Service;

import java.util.List;

import com.secc_sistema.admision_cupo.Model_Entities.DatosJudiciales;


public interface IDatosJudicialesService {
    
    public List<DatosJudiciales> buscarTodo();

    public List<DatosJudiciales> buscarPor(String criterio);

    public DatosJudiciales buscarPorId(Long id);
    
    public void guardar(DatosJudiciales datosJudiciales);
}
