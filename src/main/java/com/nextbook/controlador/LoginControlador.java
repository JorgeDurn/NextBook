package com.nextbook.controlador;

import com.nextbook.modelo.Usuario;
import com.nextbook.servicio.UsuarioServicio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
public class LoginControlador {

    private final UsuarioServicio usuarioServicio;

    public LoginControlador(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout,
                        Model model) {
        if (error != null) {
            model.addAttribute("error", "Usuario o contraseña incorrectos.");
        }
        if (logout != null) {
            model.addAttribute("logout", "Has cerrado sesión correctamente.");
        }
        return "login";
    }

    @GetMapping("/recuperar-password")
    public String mostrarFormularioRecuperacion() {
        return "recuperar-password";
    }

    @PostMapping("/recuperar-password")
    public String procesarRecuperacion(@RequestParam("email") String email, Model model) {
        Usuario usuario = usuarioServicio.buscarPorEmail(email);
        if (usuario != null) {
            String nueva = generarContrasenaAleatoria();
            usuarioServicio.actualizarContrasena(email, nueva);
            model.addAttribute("mensaje", "Nueva contraseña generada: " + nueva);
        } else {
            model.addAttribute("mensaje", "No existe una cuenta con ese correo.");
        }
        return "recuperar-password";
    }

    private String generarContrasenaAleatoria() {
        return UUID.randomUUID().toString().substring(0, 8);
    }
}
