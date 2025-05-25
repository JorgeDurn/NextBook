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

    // 🔐 Login con Spring Security
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepositorio.findByEmail(email);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

        return org.springframework.security.core.userdetails.User
            .withUsername(usuario.getEmail())
            .password(usuario.getContrasena())
            .roles(usuario.getRol())  // Ej: "ADMIN", "USER"
            .build();
    }

    // ✅ Recuperación de contraseña: buscar usuario por email
    public Usuario buscarPorEmail(String email) {
        return usuarioRepositorio.findByEmail(email);
    }

    // 🔁 Restablecer la contraseña
    public void actualizarContrasena(String email, String nuevaContrasena) {
        Usuario usuario = usuarioRepositorio.findByEmail(email);
        if (usuario != null) {
            usuario.setContrasena(passwordEncoder.encode(nuevaContrasena));
            usuarioRepositorio.save(usuario);
        }
    }

    // Otras operaciones CRUD útiles
    public List<Usuario> listarTodos() {
        return usuarioRepositorio.findAll();
    }

    public Optional<Usuario> obtenerPorId(Long id) {
        return usuarioRepositorio.findById(id);
    }

    public Usuario guardar(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

    public void eliminar(Long id) {
        usuarioRepositorio.deleteById(id);
    }
}
