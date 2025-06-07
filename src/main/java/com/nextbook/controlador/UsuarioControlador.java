package com.nextbook.controlador;

import com.nextbook.modelo.Usuario;
import com.nextbook.servicio.UsuarioServicio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsuarioControlador {

    private final UsuarioServicio usuarioServicio;

    public UsuarioControlador(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    // Listar usuarios
    @GetMapping("/usuarios")
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioServicio.listarTodos());
        return "usuarios/lista";
    }

    // Mostrar formulario para nuevo usuario
    @GetMapping("/usuarios/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuarios/formulario";
    }

    // Guardar usuario (nuevo o editado)
    @PostMapping("/usuarios/guardar")
    public String guardarUsuario(@ModelAttribute Usuario usuario) {
        usuarioServicio.guardar(usuario);
        return "redirect:/usuarios";
    }

    // Registro desde el admin (opcional si lo sigues usando)
    @PostMapping("/admin/registro")
    public String registro(@RequestParam String email,
                            @RequestParam String contrasena,
                            Model model) {
        try {
            Usuario usuario = new Usuario();
            usuario.setEmail(email);
            usuario.setContrasena(contrasena);
            usuario.setRol("USER");
            usuarioServicio.guardar(usuario);
            return "redirect:/login?registroExitoso";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "registro";
        }
    }
}
