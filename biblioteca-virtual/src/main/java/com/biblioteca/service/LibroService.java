package com.biblioteca.service;

import com.biblioteca.model.Libro;
import java.util.List;

public interface LibroService {
    List<Libro> listarLibros();
    Libro obtenerLibroPorId(Long id);
    Libro guardarLibro(Libro libro);
    void eliminarLibro(Long id);
}
 