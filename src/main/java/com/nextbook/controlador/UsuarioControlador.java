package com.nextbook.controlador;

import com.nextbook.servicio.UsuarioServicio;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UsuarioControlador {

    private final UsuarioServicio usuarioServicio;

    public UsuarioControlador(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    @PostMapping("/cambiar-contrasena")
    public String cambiarContrasena(@RequestParam String email, @RequestParam String nuevaContrasena) {
        usuarioServicio.actualizarContrasena(email, nuevaContrasena);
        // ✅ Redirigir al login después de cambiar la contraseña
        return "redirect:/login?logout";
    }
}
