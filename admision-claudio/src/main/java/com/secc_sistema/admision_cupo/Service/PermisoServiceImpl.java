package com.secc_sistema.admision_cupo.Service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.secc_sistema.admision_cupo.Model_Entities.Permiso;
import com.secc_sistema.admision_cupo.Repository.IPermisoRepository;

@Service
public class PermisoServiceImpl implements IPermisoService  {
    
    @Autowired
    IPermisoRepository permisoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Permiso> buscarTodo() {

        return permisoRepository.findAll();
    }

    @Override
    public List<Permiso> buscarPor(String criterio) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPor'");
    }

    @Override
    @Transactional(readOnly = true)
    public Permiso buscarPorId(Long id) {
        
        return permisoRepository.findById(id).orElse(null);
    }

    @Override
    public void guardar(Permiso permiso) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'guardar'");
    }
    
}

