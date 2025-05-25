package com.nextbook.nextbook.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextbook.nextbook.modelo.Devolucion;
import com.nextbook.nextbook.repositorio.DevolucionRepositorio;

@Service
public class DevolucionServicio {
    @Autowired private DevolucionRepositorio repo;

    public List<Devolucion> listarTodas() { return repo.findAll(); }
    public Devolucion guardar(Devolucion d) { return repo.save(d); }
}