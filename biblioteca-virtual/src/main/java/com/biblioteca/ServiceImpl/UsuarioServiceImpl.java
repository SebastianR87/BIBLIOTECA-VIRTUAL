package com.biblioteca.ServiceImpl;

import com.biblioteca.model.Usuario;
import com.biblioteca.repository.UsuarioRepository;
import com.biblioteca.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario login(String correo, String contraseña) {
        return usuarioRepository.findByCorreo(correo)
                .filter(u -> u.getContraseña().equals(contraseña))
                .orElse(null);
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario actualizarUsuario(Long id, Usuario usuarioActualizado) {
        return usuarioRepository.findById(id)
                .map(u -> {
                    u.setNombre(usuarioActualizado.getNombre());
                    u.setCorreo(usuarioActualizado.getCorreo());
                    u.setContraseña(usuarioActualizado.getContraseña());
                    u.setRol(usuarioActualizado.getRol());
                    return usuarioRepository.save(u);
                })
                .orElse(null);
    }

    @Override
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
public Usuario obtenerUsuario(Long id) {
    return usuarioRepository.findById(id).orElse(null);
}

}
