package com.example.caso.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.caso.entity.Categorias;
import com.example.caso.repository.RepositoryCategoria;
import com.example.caso.services.interfase.CategoriasServices;

import jakarta.transaction.Transactional;

@Service("categoriaServiceImpl")
@Transactional
public class CategoriaServiceImplement implements CategoriasServices {

    @Autowired
    @Qualifier("categoriaRepository")
    private RepositoryCategoria categoriarepository;

    @Override
    public List<Categorias> listAllCategorias() {

        return (List<Categorias>) categoriarepository.findAll();
    }

    @Override
    public Optional<Categorias> findByIdCategoria(long id) {

        return categoriarepository.findById(id);
    }

    @Override
    public Categorias updateCategoria(Categorias categorias) {

        return categoriarepository.save(categorias);
    }

    @Override
    public void deleteCategoria(long id) {

        categoriarepository.deleteById(id);
    }

    @Override
    public Categorias create(Categorias categorias) {

        return categoriarepository.save(categorias);
    }

}
