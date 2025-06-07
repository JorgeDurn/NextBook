package com.nextbook.controlador;

import com.nextbook.servicio.UsuarioServicio;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;  // <-- Añadido
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PerfilControlador {

    private final UsuarioServicio usuarioServicio;

    public PerfilControlador(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    // ✅ NUEVO: Mostrar el formulario de cambio de contraseña
    @GetMapping("/perfil/cambiar-contrasena")
    public String mostrarFormularioCambioContrasena() {
        return "perfil/cambiar-contrasena";
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
            return "perfil/cambiar-contrasena";
        }
    }
}
