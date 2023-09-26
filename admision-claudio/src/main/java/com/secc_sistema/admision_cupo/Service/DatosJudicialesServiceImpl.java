package com.secc_sistema.admision_cupo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.secc_sistema.admision_cupo.Model_Entities.DatosJudiciales;

import com.secc_sistema.admision_cupo.Repository.IDatosJudicialesRepository;

@Service
public class DatosJudicialesServiceImpl implements IDatosJudicialesService {

    @Autowired
    IDatosJudicialesRepository datosJudicialesRepository;

    @Override
    public List<DatosJudiciales> buscarTodo() {
      return datosJudicialesRepository.findAll();
    }

    @Override
    public List<DatosJudiciales> buscarPor(String criterio) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPor'");
    }

    @Override
    public DatosJudiciales buscarPorId(Long id) {
       return datosJudicialesRepository.findById(id).orElse(null);
    }

    @Override
    public void guardar(DatosJudiciales datosJudiciales) {
       datosJudicialesRepository.save(datosJudiciales);
    }
    
}
