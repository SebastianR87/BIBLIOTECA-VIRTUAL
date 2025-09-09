package com.biblioteca.model;

import lombok.Data;

@Data
public class LoginRequest {
    private String correo;
    private String contraseña;
}
