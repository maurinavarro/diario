package com.secc_sistema.admision_cupo.Service;

import java.util.List;

import com.secc_sistema.admision_cupo.Model_Entities.DatosCriminologico;


public interface IDatosCriminologicosService {
    
    public List<DatosCriminologico> buscarTodo();

    public List<DatosCriminologico> buscarPor(String criterio);

    public DatosCriminologico buscarPorId(Long id);
    
    public void guardar(DatosCriminologico datosCriminologico);
}
