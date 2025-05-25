package com.nextbook.nextbook.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nextbook.nextbook.modelo.Devolucion;
import com.nextbook.nextbook.servicio.DevolucionServicio;


@Controller
@RequestMapping("/devoluciones")
public class DevolucionControlador {
    @Autowired private DevolucionServicio devolucionServicio;

    @GetMapping
    public String listarDevoluciones(Model modelo) {
        modelo.addAttribute("devoluciones", devolucionServicio.listarTodas());
        return "devoluciones/lista";
    }

    @GetMapping("/nuevo")
    public String nuevaDevolucion(Model modelo) {
        modelo.addAttribute("devolucion", new Devolucion());
        return "devoluciones/formulario";
    }

    @PostMapping("/guardar")
    public String guardarDevolucion(@ModelAttribute Devolucion devolucion) {
        devolucionServicio.guardar(devolucion);
        return "redirect:/devoluciones";
    }
}
