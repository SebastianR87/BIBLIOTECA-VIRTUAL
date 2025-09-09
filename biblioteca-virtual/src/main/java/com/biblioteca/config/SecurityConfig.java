package com.biblioteca.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Desactiva CSRF
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll() // Permite todo
            )
            .formLogin(form -> form.disable()) // Quita login por formulario
            .httpBasic(httpBasic -> httpBasic.disable()); // Quita autenticación básica

        return http.build();
    }
}  
