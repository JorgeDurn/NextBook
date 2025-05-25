package com.nextbook.nextbook.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nextbook.nextbook.modelo.Devolucion;

@Repository
public interface DevolucionRepositorio extends JpaRepository<Devolucion, Long> {
}
