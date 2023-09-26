package com.secc_sistema.admision_cupo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.secc_sistema.admision_cupo.Model_Entities.Fuerza;
import com.secc_sistema.admision_cupo.Repository.IFuerzaRepository;

@Service
public class FuerzaServiceImpl implements IFuerzaService {

   
    @Autowired
    IFuerzaRepository fuerzaRepository;
   
    @Override
    @Transactional(readOnly = true)
    public List<Fuerza> buscarTodo() {
       return fuerzaRepository.findAll();
    }

    @Override
    public List<Fuerza> buscarPor(String criterio) {
       // TODO Auto-generated method stub
       throw new UnsupportedOperationException("Unimplemented method 'buscarTodo'");
    }

    @Override
    public Fuerza buscarPorId(Long id) {
      return fuerzaRepository.findById(id).orElse(null);
    }

    @Override
    public void guardar(Fuerza fuerza) {
       fuerzaRepository.save(fuerza);
    }
    
}
