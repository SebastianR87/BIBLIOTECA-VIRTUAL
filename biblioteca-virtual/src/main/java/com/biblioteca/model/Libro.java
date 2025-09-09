package com.biblioteca.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "libros")
@Data  // Lombok genera getters, setters, toString, equals y hashCode
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String autor;
    private String editorial;
    private String isbn;
    private int anioPublicacion;
    private String idioma;
}

