package com.example.caso.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.caso.entity.Alquileres;
import com.example.caso.repository.RepositoryAlquiler;
import com.example.caso.services.interfase.AlquileresServices;

import jakarta.transaction.Transactional;

@Service ("alquilerServiceImpl")
@Transactional
public class AlquilerServiceImplement implements AlquileresServices {

    @Autowired
    @Qualifier ("alquilerRepository")
    private RepositoryAlquiler alquilerRepository;

    @Override
    public List<Alquileres> listAllaquileres() {

        return  (List<Alquileres>) alquilerRepository.findAll();

    }

    @Override
    public Optional<Alquileres> findByIdAlquileres(long id) {

        return alquilerRepository.findById(id);
    }

    @Override
    public Alquileres updateAlquileres(Alquileres alquileres) {

        return alquilerRepository.save(alquileres);
    }
    @Override
    public void deleteAlquileres(long id) {
        
        alquilerRepository.deleteById(id);
    }

    @Override
    public Alquileres create(Alquileres alquileres) {
        
        return alquilerRepository.save(alquileres);
    
    }
    
}
