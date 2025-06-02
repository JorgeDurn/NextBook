package com.nextbook.controlador;

import com.nextbook.servicio.UsuarioServicio;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PerfilControlador {

    private final UsuarioServicio usuarioServicio;

    public PerfilControlador(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    // Cambio de contraseña del propio usuario
    @PostMapping("/perfil/cambiar-contrasena")
    public String cambiarContrasena(@RequestParam String nuevaContrasena,
                                     Authentication authentication,
                                     Model model) {
        try {
            String emailUsuarioActual = authentication.getName();
            usuarioServicio.actualizarContrasena(emailUsuarioActual, nuevaContrasena);
            model.addAttribute("mensaje", "Contraseña actualizada correctamente.");
            return "redirect:/login?logout";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "perfil-cambiar-contrasena"; // Vista de error de usuario normal
        }
    }
}
