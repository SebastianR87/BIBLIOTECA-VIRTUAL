package com.biblioteca.service;

import com.biblioteca.model.Usuario;
import java.util.List;

public interface UsuarioService {
    Usuario login(String correo, String contraseña);
    List<Usuario> listarUsuarios();
    Usuario crearUsuario(Usuario usuario);
    Usuario obtenerUsuario(Long id);
    Usuario actualizarUsuario(Long id, Usuario usuarioActualizado);
    void eliminarUsuario(Long id);
}

