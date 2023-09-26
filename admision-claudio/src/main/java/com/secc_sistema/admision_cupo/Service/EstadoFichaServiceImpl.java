package com.secc_sistema.admision_cupo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.secc_sistema.admision_cupo.Model_Entities.estadoFicha;
import com.secc_sistema.admision_cupo.Repository.IEstadoFichaRepository;

@Service
public class EstadoFichaServiceImpl implements IEstadoFichaService {

    @Autowired
    IEstadoFichaRepository estadoFichaRepository;

    @Override
    public List<estadoFicha> buscarTodo() {
        return estadoFichaRepository.findAll();
    }

    @Override
    public List<estadoFicha> buscarPor(String criterio) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPor'");
    }

    @Override
    public estadoFicha buscarPorId(Long id) {
        return estadoFichaRepository.findById(id).orElse(null);
    }

    @Override
    public void guardar(estadoFicha estadoFicha) {
       estadoFichaRepository.save(estadoFicha);
    }
    
}
