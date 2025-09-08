package com.biblioteca.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

public class JwtUtil {
    // Clave secreta de al menos 256 bits (32 caracteres)
    private static final String SECRET_KEY = "mi_clave_secreta_super_segura_123456";

    private static Key getSigningKey() {
        // Convierte la cadena a bytes UTF-8 y genera la clave HMAC
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    }

    public static String generateToken(String correo) {
        return Jwts.builder()
                .setSubject(correo)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 día
                .signWith(getSigningKey()) // ahora usamos Key
                .compact();
    }
}
