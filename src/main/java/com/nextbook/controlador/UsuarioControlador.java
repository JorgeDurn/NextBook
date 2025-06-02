package com.nextbook.controlador;

import com.nextbook.modelo.Usuario;
import com.nextbook.servicio.UsuarioServicio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UsuarioControlador {

    private final UsuarioServicio usuarioServicio;

    public UsuarioControlador(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

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

    @PostMapping("/admin/cambiar-contrasena")
    public String cambiarContrasena(@RequestParam String email,
                                     @RequestParam String nuevaContrasena,
                                     Model model) {
        try {
            usuarioServicio.actualizarContrasena(email, nuevaContrasena);
            model.addAttribute("mensaje", "Contraseña actualizada correctamente");
            return "redirect:/login?logout";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "admin-cambiar-contrasena";
        }
    }

    // ✅ NUEVO RESET ADMIN
    @GetMapping("/admin/reset-contrasena")
    public String mostrarReset() {
        return "admin-reset-contrasena";
    }

    @PostMapping("/admin/reset-contrasena")
    public String resetContrasena(@RequestParam String email,
                                   @RequestParam String nuevaContrasena,
                                   Model model) {
        try {
            usuarioServicio.actualizarContrasena(email, nuevaContrasena);
            model.addAttribute("mensaje", "Contraseña reseteada correctamente.");
            return "admin-reset-contrasena";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "admin-reset-contrasena";
        }
    }
}
