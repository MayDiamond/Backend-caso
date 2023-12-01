package com.example.caso.services.interfase;

import java.util.List;
import java.util.Optional;


import com.example.caso.entity.Lectores;

public interface LectoresServices {

    public abstract List <Lectores> listAllLectores();

    public abstract Optional <Lectores> findByIdLector (Long id);

    public abstract Lectores updateLectores (Lectores lectores);

    public abstract void deleteLector (Long id);

    Lectores create(Lectores lectores);
    
}
