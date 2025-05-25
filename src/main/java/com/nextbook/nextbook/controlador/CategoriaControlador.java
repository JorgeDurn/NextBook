package com.nextbook.nextbook.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nextbook.nextbook.modelo.Categoria;
import com.nextbook.nextbook.servicio.CategoriaServicio;


@Controller
@RequestMapping("/categorias")
public class CategoriaControlador {
    @Autowired private CategoriaServicio categoriaServicio;

    @GetMapping
    public String listarCategorias(Model modelo) {
        modelo.addAttribute("categorias", categoriaServicio.listarTodas());
        return "categorias/lista";
    }

    @GetMapping("/nuevo")
    public String nuevaCategoria(Model modelo) {
        modelo.addAttribute("categoria", new Categoria());
        return "categorias/formulario";
    }

    @PostMapping("/guardar")
    public String guardarCategoria(@ModelAttribute Categoria categoria) {
        categoriaServicio.guardar(categoria);
        return "redirect:/categorias";
    }
}