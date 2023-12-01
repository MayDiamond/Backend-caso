package com.example.caso.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.caso.entity.Lectores;

@Repository ("lectorRepository")
public interface RepositoryLectores extends CrudRepository <Lectores, Long>{
    
    void deleteById(Long Id);
}
