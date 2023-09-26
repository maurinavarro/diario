package com.secc_sistema.admision_cupo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.secc_sistema.admision_cupo.Model_Entities.Detenido;
import com.secc_sistema.admision_cupo.Repository.IDetenidoRepository;

@Service
public class DetenidoServiceImpl implements IDetenidoService {

   @Autowired
   IDetenidoRepository detenidoRepository;

   @Override
   public List<Detenido> buscarTodo() {
      return detenidoRepository.buscarSoloHabilitados();
   }

   @Override
   public List<Detenido> buscarPor(String criterio) {
      return detenidoRepository.buscarPor(criterio);
   }

   @Override
   public Detenido buscarPorId(Long id) {
      return detenidoRepository.findById(id).orElse(null);
   }

   @Override
   public Detenido guardar(Detenido detenido) {
      Detenido detenidoGuardado = detenidoRepository.save(detenido);
      return detenidoGuardado;
   }

}
