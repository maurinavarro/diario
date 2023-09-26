package com.secc_sistema.admision_cupo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.secc_sistema.admision_cupo.Model_Entities.Usuario;
import com.secc_sistema.admision_cupo.Repository.IUsuarioRepository;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> buscarPor(String criterio) {
        return usuarioRepository.buscarPor(criterio);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> buscarTodos() {
        return usuarioRepository.buscarSoloHabilitados();

    }

    @Override
    @Transactional
    public void guardar(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario findByNombreOrEmail(String nombre, String email) {
        return usuarioRepository.findByNombreOrEmail(nombre, email);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario buscarPorNombre(String nombreUsuario) {
        return usuarioRepository.findByNombre(nombreUsuario);
    }
}
