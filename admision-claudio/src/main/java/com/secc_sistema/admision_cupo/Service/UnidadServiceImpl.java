package com.secc_sistema.admision_cupo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.secc_sistema.admision_cupo.Model_Entities.Unidad;
import com.secc_sistema.admision_cupo.Repository.IUnidadRepository;

@Service
public class UnidadServiceImpl implements IUnidadService { 

    @Autowired
    IUnidadRepository unidadRepository;

    @Override
    public List<Unidad> buscarTodo() {
        return unidadRepository.findAll();
    }

    @Override
    public List<Unidad> buscarPor(String criterio) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPor'");
    }

    @Override
    public Unidad buscarPorId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorId'");
    }

    @Override
    public void guardar(Unidad unidad) {
       unidadRepository.save(unidad);   
}

}