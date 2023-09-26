package com.secc_sistema.admision_cupo.Service;

import java.util.List;

import com.secc_sistema.admision_cupo.Model_Entities.estadoFicha;



public interface IEstadoFichaService  {

    public List<estadoFicha> buscarTodo();

    public List<estadoFicha> buscarPor(String criterio);

    public estadoFicha buscarPorId(Long id);
    
    public void guardar(estadoFicha estadoFicha);    
}
