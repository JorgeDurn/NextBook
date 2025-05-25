package com.nextbook.nextbook.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nextbook.nextbook.modelo.Prestamo;
import com.nextbook.nextbook.servicio.PrestamoServicio;


@Controller
@RequestMapping("/prestamos")
public class PrestamoControlador {
    @Autowired private PrestamoServicio prestamoServicio;

    @GetMapping
    public String listarPrestamos(Model modelo) {
        modelo.addAttribute("prestamos", prestamoServicio.listarTodos());
        return "prestamos/lista";
    }

    @GetMapping("/nuevo")
    public String nuevoPrestamo(Model modelo) {
        modelo.addAttribute("prestamo", new Prestamo());
        return "prestamos/formulario";
    }

    @PostMapping("/guardar")
    public String guardarPrestamo(@ModelAttribute Prestamo prestamo) {
        prestamoServicio.guardar(prestamo);
        return "redirect:/prestamos";
    }
}