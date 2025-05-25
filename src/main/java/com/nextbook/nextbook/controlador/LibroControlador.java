package com.nextbook.nextbook.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nextbook.nextbook.modelo.Libro;
import com.nextbook.nextbook.servicio.LibroServicio;


@Controller
@RequestMapping("/libros")
public class LibroControlador {
    @Autowired private LibroServicio libroServicio;

    @GetMapping
    public String listarLibros(Model modelo) {
        modelo.addAttribute("libros", libroServicio.listarTodos());
        return "libros/lista";
    }

    @GetMapping("/nuevo")
    public String nuevoLibro(Model modelo) {
        modelo.addAttribute("libro", new Libro());
        return "libros/formulario";
    }

    @PostMapping("/guardar")
    public String guardarLibro(@ModelAttribute Libro libro) {
        libroServicio.guardar(libro);
        return "redirect:/libros";
    }
}