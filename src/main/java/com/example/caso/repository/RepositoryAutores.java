package com.example.caso.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.caso.entity.Autores;

@Repository ("autorRepository")
public interface RepositoryAutores extends CrudRepository <Autores, Long>{
    
    void deleteById(Long Id);
}
