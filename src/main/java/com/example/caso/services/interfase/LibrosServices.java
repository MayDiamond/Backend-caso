package com.example.caso.services.interfase;

import java.util.List;
import java.util.Optional;


import com.example.caso.entity.Libros;

public interface LibrosServices {

    public abstract List <Libros> listAllLibros();

    public abstract Optional <Libros> findByIdLibros (long id);

    public abstract Libros updateLibros (Libros libros);

    public abstract void deleteLibro (long id);

    Libros create(Libros libros);
    
}
