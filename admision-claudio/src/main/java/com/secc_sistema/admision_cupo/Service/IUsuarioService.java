package com.secc_sistema.admision_cupo.Service;

import java.util.List;

import com.secc_sistema.admision_cupo.Model_Entities.Usuario;


public interface IUsuarioService {


    Usuario findByNombreOrEmail(String nombre, String email);

    public void guardar (Usuario usuario);
    
    public List<Usuario> buscarTodos();

    public List<Usuario> buscarPor(String criterio);

    public Usuario buscarPorId(Long id);

    public Usuario buscarPorNombre(String nombreUsuario);
}