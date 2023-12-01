package com.example.caso.services.interfase;

import java.util.List;
import java.util.Optional;

import com.example.caso.entity.Categorias;

public interface CategoriasServices {

    public abstract List <Categorias> listAllCategorias();

    public abstract Optional <Categorias> findByIdCategoria (long id);

    public abstract Categorias updateCategoria (Categorias categorias);

    public abstract void deleteCategoria (long id);

    Categorias create(Categorias categorias);
    
}
