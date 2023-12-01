package com.example.caso.services.interfase;

import java.util.List;
import java.util.Optional;

import com.example.caso.entity.Autores;

public interface AutoresServices {

    public abstract List <Autores> listAllAutores();

    public abstract Optional <Autores> findByIdAutor (long id);

    public abstract Autores updateAutores (Autores autores);

    public abstract void deleteAutores (long id);

    Autores create(Autores autores);
    
}
