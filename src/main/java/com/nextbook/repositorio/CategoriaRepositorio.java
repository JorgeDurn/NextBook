package com.nextbook.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nextbook.modelo.Categoria;

@Repository
public interface CategoriaRepositorio extends JpaRepository<Categoria, Long> {
}
