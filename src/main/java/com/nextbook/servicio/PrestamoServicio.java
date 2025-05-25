package com.nextbook.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextbook.modelo.Prestamo;
import com.nextbook.repositorio.PrestamoRepositorio;

@Service
public class PrestamoServicio {
    @Autowired private PrestamoRepositorio repo;

    public List<Prestamo> listarTodos() { return repo.findAll(); }
    public Prestamo guardar(Prestamo p) { return repo.save(p); }
    public Optional<Prestamo> obtenerPorId(Long id) { return repo.findById(id); }
    public void eliminar(Long id) { repo.deleteById(id); }
}