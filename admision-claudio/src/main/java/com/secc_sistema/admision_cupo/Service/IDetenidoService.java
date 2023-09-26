package com.secc_sistema.admision_cupo.Service;

import java.util.List;

import com.secc_sistema.admision_cupo.Model_Entities.Detenido;


public interface IDetenidoService {
    
    public List<Detenido> buscarTodo();

    public List<Detenido> buscarPor(String criterio);

    public Detenido buscarPorId(Long id);

    public Detenido guardar(Detenido detenido);

    


}
