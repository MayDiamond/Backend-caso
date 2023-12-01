package com.example.caso.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.caso.entity.Editoriales;

@Repository ("editorialRepository")
public interface RepositoryEditoriales extends CrudRepository <Editoriales, Long> {
    
    void deleteById(Long Id);
}
