package com.nextbook.servicio;

import com.nextbook.modelo.Usuario;
import com.nextbook.repositorio.UsuarioRepositorio;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicio implements UserDetailsService {

    private final UsuarioRepositorio usuarioRepositorio;
    private final PasswordEncoder passwordEncoder;

    public UsuarioServicio(UsuarioRepositorio usuarioRepositorio, PasswordEncoder passwordEncoder) {
        this.usuarioRepositorio = usuarioRepositorio;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepositorio.findByEmail(email);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

        return org.springframework.security.core.userdetails.User
            .withUsername(usuario.getEmail())
            .password(usuario.getContrasena())
            .roles(usuario.getRol())
            .build();
    }

    public Usuario buscarPorEmail(String email) {
        return usuarioRepositorio.findByEmail(email);
    }

    public void actualizarContrasena(String email, String nuevaContrasena) {
        if (!validarContrasenaSegura(nuevaContrasena)) {
            throw new IllegalArgumentException("La contraseña no cumple los requisitos de seguridad.");
        }
        Usuario usuario = usuarioRepositorio.findByEmail(email);
        if (usuario != null) {
            usuario.setContrasena(passwordEncoder.encode(nuevaContrasena));
            usuarioRepositorio.save(usuario);
        }
    }

    public List<Usuario> listarTodos() {
        return usuarioRepositorio.findAll();
    }

    public Optional<Usuario> obtenerPorId(Long id) {
        return usuarioRepositorio.findById(id);
    }

    public Usuario guardar(Usuario usuario) {
        if (!validarContrasenaSegura(usuario.getContrasena())) {
            throw new IllegalArgumentException("La contraseña no cumple los requisitos de seguridad.");
        }
        usuario.setContrasena(passwordEncoder.encode(usuario.getContrasena()));
        return usuarioRepositorio.save(usuario);
    }

    private boolean validarContrasenaSegura(String contrasena) {
        return contrasena.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$");
    }
}
