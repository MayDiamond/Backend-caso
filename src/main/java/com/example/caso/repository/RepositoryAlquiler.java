package com.example.caso.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.caso.entity.Alquileres;

@Repository ("alquilerRepository")
public interface RepositoryAlquiler extends CrudRepository <Alquileres, Long> {
    
    void deleteById(Long Id);
}
