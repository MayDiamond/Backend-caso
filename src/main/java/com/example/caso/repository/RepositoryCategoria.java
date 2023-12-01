package com.example.caso.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.caso.entity.Categorias;

@Repository ("categoriaRepository")
public interface RepositoryCategoria extends CrudRepository <Categorias, Long>{
    
    void deleteById(Long Id);


}
