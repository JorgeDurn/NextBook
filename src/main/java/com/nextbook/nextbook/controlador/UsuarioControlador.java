package com.nextbook.nextbook.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nextbook.nextbook.modelo.Usuario;
import com.nextbook.nextbook.servicio.UsuarioServicio;


@Controller
@RequestMapping("/usuarios")
public class UsuarioControlador {
    @Autowired private UsuarioServicio usuarioServicio;

    @GetMapping
    public String listarUsuarios(Model modelo) {
        modelo.addAttribute("usuarios", usuarioServicio.listarTodos());
        return "usuarios/lista";
    }

    @GetMapping("/nuevo")
    public String nuevoUsuario(Model modelo) {
        modelo.addAttribute("usuario", new Usuario());
        return "usuarios/formulario";
    }

    @PostMapping("/guardar")
    public String guardarUsuario(@ModelAttribute Usuario usuario) {
        usuarioServicio.guardar(usuario);
        return "redirect:/usuarios";
    }
}
