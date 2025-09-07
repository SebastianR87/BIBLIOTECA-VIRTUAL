package com.biblioteca.controller;

import com.biblioteca.model.Libro;
import com.biblioteca.service.LibroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }


    @GetMapping
    public List<Libro> listarLibros() {
        return libroService.listarLibros();
    } 

 
    @GetMapping("/{id}")
    public Libro obtenerLibroPorId(@PathVariable Long id) {
        return libroService.obtenerLibroPorId(id);
    }


    @PostMapping
    public Libro guardarLibro(@RequestBody Libro libro) {
        return libroService.guardarLibro(libro);
    }


    @PutMapping("/{id}")
    public Libro actualizarLibro(@PathVariable Long id, @RequestBody Libro libro) {
        Libro libroExistente = libroService.obtenerLibroPorId(id);
        if (libroExistente != null) {
            libroExistente.setTitulo(libro.getTitulo());
            libroExistente.setAutor(libro.getAutor());
            libroExistente.setEditorial(libro.getEditorial());
            libroExistente.setIsbn(libro.getIsbn());
            libroExistente.setAnioPublicacion(libro.getAnioPublicacion());
            libroExistente.setIdioma(libro.getIdioma());
            return libroService.guardarLibro(libroExistente);
        }
        return null;
    }


    @DeleteMapping("/{id}")
    public void eliminarLibro(@PathVariable Long id) {
        libroService.eliminarLibro(id);
    }

   

   

}
