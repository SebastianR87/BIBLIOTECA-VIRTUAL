package com.biblioteca.controller;
import java.util.Map;
import com.biblioteca.config.JwtUtil;
import com.biblioteca.model.LoginRequest;
import com.biblioteca.model.Usuario;
import com.biblioteca.service.UsuarioService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // LOGIN
 @PostMapping("/login")
public ResponseEntity<?> login(@RequestBody LoginRequest request) {
    Usuario u = usuarioService.login(request.getCorreo(), request.getContraseña());

    Map<String, Object> response = new HashMap<>();

    if (u == null) {
        response.put("error", "Correo o contraseña incorrectos");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

    String token = JwtUtil.generateToken(u.getCorreo());
    response.put("token", token);

    return ResponseEntity.ok(response);
}


    // CRUD
    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return usuarioService.crearUsuario(usuario);
    }

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @GetMapping("/{id}")
    public Usuario obtenerUsuario(@PathVariable Long id) {
        return usuarioService.obtenerUsuario(id);
    }

    @PutMapping("/{id}")
    public Usuario actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        return usuarioService.actualizarUsuario(id, usuario);
    }

    @DeleteMapping("/{id}")
    public String eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
        return "Usuario eliminado correctamente";
    }
}
