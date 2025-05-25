package com.nextbook.nextbook.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextbook.nextbook.modelo.Libro;
import com.nextbook.nextbook.repositorio.LibroRepositorio;

@Service
public class LibroServicio {
    @Autowired private LibroRepositorio repo;

    public List<Libro> listarTodos() { return repo.findAll(); }
    public Libro guardar(Libro l) { return repo.save(l); }
    public Optional<Libro> obtenerPorId(Long id) { return repo.findById(id); }
    public void eliminar(Long id) { repo.deleteById(id); }
}