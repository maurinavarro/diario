package com.secc_sistema.admision_cupo.Service;

import java.util.List;

import com.secc_sistema.admision_cupo.Model_Entities.Fuerza;


public interface IFuerzaService {
    
    public List<Fuerza> buscarTodo();

    public List<Fuerza> buscarPor(String criterio);

    public Fuerza buscarPorId(Long id);
    
    public void guardar(Fuerza fuerza);
}
