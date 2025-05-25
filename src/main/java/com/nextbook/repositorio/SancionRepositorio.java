package com.nextbook.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nextbook.modelo.Sancion;

@Repository
public interface SancionRepositorio extends JpaRepository<Sancion, Long> {
}
