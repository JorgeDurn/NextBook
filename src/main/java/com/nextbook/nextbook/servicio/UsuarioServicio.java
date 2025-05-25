package com.nextbook.nextbook.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextbook.nextbook.modelo.Usuario;
import com.nextbook.nextbook.repositorio.UsuarioRepositorio;

@Service
public class UsuarioServicio {
    @Autowired private UsuarioRepositorio repo;

    public List<Usuario> listarTodos() { return repo.findAll(); }
    public Usuario guardar(Usuario u) { return repo.save(u); }
    public Optional<Usuario> obtenerPorId(Long id) { return repo.findById(id); }
    public void eliminar(Long id) { repo.deleteById(id); }
    public Usuario buscarPorEmail(String email) { return repo.findByEmail(email); }
}