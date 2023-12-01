package com.example.caso.services.interfase;

import java.util.List;
import java.util.Optional;

import com.example.caso.entity.Alquileres;

public interface AlquileresServices {

    public abstract List <Alquileres> listAllaquileres();

    public abstract Optional <Alquileres> findByIdAlquileres (long id);

    public abstract Alquileres updateAlquileres (Alquileres alquileres);

    public abstract void deleteAlquileres (long id);

    Alquileres create(Alquileres alquileres);
    
}
