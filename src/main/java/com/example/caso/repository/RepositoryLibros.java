package com.example.caso.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.caso.entity.Libros;

@Repository ("libroRepository")
public interface RepositoryLibros extends CrudRepository <Libros, Long> {
    
    void deleteById(Long Id);
}
