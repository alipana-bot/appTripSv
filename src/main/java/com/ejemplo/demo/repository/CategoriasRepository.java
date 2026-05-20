package com.ejemplo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejemplo.demo.model.Categoria;

public interface CategoriasRepository extends JpaRepository<Categoria, Integer>{

}