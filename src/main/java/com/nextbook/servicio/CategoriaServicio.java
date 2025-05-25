package com.nextbook.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextbook.modelo.Categoria;
import com.nextbook.repositorio.CategoriaRepositorio;

@Service
public class CategoriaServicio {
    @Autowired private CategoriaRepositorio repo;

    public List<Categoria> listarTodas() { return repo.findAll(); }
    public Categoria guardar(Categoria c) { return repo.save(c); }
}