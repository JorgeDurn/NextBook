package com.nextbook.nextbook.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nextbook.nextbook.modelo.Sancion;

@Repository
public interface SancionRepositorio extends JpaRepository<Sancion, Long> {
}
