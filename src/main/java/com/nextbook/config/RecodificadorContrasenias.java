package com.nextbook.config;

import com.nextbook.modelo.Usuario;
import com.nextbook.repositorio.UsuarioRepositorio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RecodificadorContrasenias implements CommandLineRunner {

    private final UsuarioRepositorio usuarioRepositorio;
    private final PasswordEncoder passwordEncoder;

    public RecodificadorContrasenias(UsuarioRepositorio usuarioRepositorio, PasswordEncoder passwordEncoder) {
        this.usuarioRepositorio = usuarioRepositorio;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        List<Usuario> usuarios = usuarioRepositorio.findAll();

        for (Usuario usuario : usuarios) {
            String contrasenaActual = usuario.getContrasena();

            if (!estaCodificada(contrasenaActual)) {
                System.out.println("➡ Codificando contraseña para usuario: " + usuario.getEmail());
                usuario.setContrasena(passwordEncoder.encode(contrasenaActual));
                usuarioRepositorio.save(usuario);
            } else {
                System.out.println("✅ Contraseña ya codificada para usuario: " + usuario.getEmail());
            }
        }
    }

    private boolean estaCodificada(String contrasena) {
        return contrasena != null && contrasena.startsWith("$2");
    }
}
