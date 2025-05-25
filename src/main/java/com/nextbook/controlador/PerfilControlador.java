package com.nextbook.controlador;

import com.nextbook.modelo.Usuario;
import com.nextbook.servicio.UsuarioServicio;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PerfilControlador {

    private final UsuarioServicio usuarioServicio;
    private final PasswordEncoder passwordEncoder;

    public PerfilControlador(UsuarioServicio usuarioServicio, PasswordEncoder passwordEncoder) {
        this.usuarioServicio = usuarioServicio;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/cambiar-contrasena")
    public String mostrarFormularioCambio() {
        return "cambiar-contrasena";
    }

    @PostMapping("/cambiar-contrasena")
    public String cambiarContrasena(@RequestParam("actual") String actual,
                                    @RequestParam("nueva") String nueva,
                                    Model model,
                                    Authentication auth) {
        String email = auth.getName(); // Email del usuario autenticado
        Usuario usuario = usuarioServicio.buscarPorEmail(email);

        if (!passwordEncoder.matches(actual, usuario.getContrasena())) {
            model.addAttribute("mensaje", "La contraseña actual es incorrecta.");
            return "cambiar-contrasena";
        }

        usuarioServicio.actualizarContrasena(email, nueva);

        // Redirige al logout tras cambiar la contraseña
        return "redirect:/logout";
    }
}
