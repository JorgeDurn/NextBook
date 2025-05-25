package com.nextbook.nextbook.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nextbook.nextbook.modelo.Sancion;
import com.nextbook.nextbook.servicio.SancionServicio;


@Controller
@RequestMapping("/sanciones")
public class SancionControlador {
    @Autowired private SancionServicio sancionServicio;

    @GetMapping
    public String listarSanciones(Model modelo) {
        modelo.addAttribute("sanciones", sancionServicio.listarTodas());
        return "sanciones/lista";
    }

    @GetMapping("/nuevo")
    public String nuevaSancion(Model modelo) {
        modelo.addAttribute("sancion", new Sancion());
        return "sanciones/formulario";
    }

    @PostMapping("/guardar")
    public String guardarSancion(@ModelAttribute Sancion sancion) {
        sancionServicio.guardar(sancion);
        return "redirect:/sanciones";
    }
}
