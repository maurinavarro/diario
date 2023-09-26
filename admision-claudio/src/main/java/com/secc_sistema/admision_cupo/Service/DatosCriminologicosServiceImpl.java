package com.secc_sistema.admision_cupo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.secc_sistema.admision_cupo.Model_Entities.DatosCriminologico;
import com.secc_sistema.admision_cupo.Repository.IDatosCriminologicoRepository;

@Service
public class DatosCriminologicosServiceImpl implements IDatosCriminologicosService {

    @Autowired
    IDatosCriminologicoRepository datosCriminologicoRepository;

    @Override
    public List<DatosCriminologico> buscarTodo() {
       return datosCriminologicoRepository.findAll();
    }

    @Override
    public List<DatosCriminologico> buscarPor(String criterio) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPor'");
    }

    @Override
    public DatosCriminologico buscarPorId(Long id) {
        return datosCriminologicoRepository.findById(id).orElse(null);
    }

    @Override
    public void guardar(DatosCriminologico datosCriminologico) {
       datosCriminologicoRepository.save(datosCriminologico);
    }
    
}
