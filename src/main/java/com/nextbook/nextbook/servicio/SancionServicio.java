package com.nextbook.nextbook.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextbook.nextbook.modelo.Sancion;
import com.nextbook.nextbook.repositorio.SancionRepositorio;

@Service
public class SancionServicio {
    @Autowired private SancionRepositorio repo;

    public List<Sancion> listarTodas() { return repo.findAll(); }
    public Sancion guardar(Sancion s) { return repo.save(s); }
}