package com.nextbook.nextbook.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nextbook.nextbook.modelo.Prestamo;

@Repository
public interface PrestamoRepositorio extends JpaRepository<Prestamo, Long> {
}
