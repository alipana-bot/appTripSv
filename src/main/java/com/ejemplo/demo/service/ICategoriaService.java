package com.ejemplo.demo.service;

import java.util.List;

import com.ejemplo.demo.model.Categoria;

public interface ICategoriaService {

    List<Categoria> buscarTodas();

    void guardar(Categoria categoria);

    void eliminar(Integer id);

    Categoria buscarPorId(Integer id);

}