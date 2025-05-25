package com.nextbook.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nextbook.modelo.Libro;

@Repository
public interface LibroRepositorio extends JpaRepository<Libro, Long> {
}
