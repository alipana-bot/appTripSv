package com.ejemplo.demo.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.ejemplo.demo.model.Categoria;
import com.ejemplo.demo.repository.CategoriasRepository;
import com.ejemplo.demo.service.ICategoriaService;

@Service
@Primary
public class CategoriaServiceJpa implements ICategoriaService {

    @Autowired
    private CategoriasRepository repo;

    @Override
    public List<Categoria> buscarTodas() {
        return repo.findAll();
    }

    @Override
    public void guardar(Categoria categoria) {
        repo.save(categoria);
    }

    @Override
    public void eliminar(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public Categoria buscarPorId(Integer id) {

        Optional<Categoria> optional = repo.findById(id);

        if(optional.isPresent()) {
            return optional.get();
        }

        return null;
    }
}