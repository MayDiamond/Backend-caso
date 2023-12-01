package com.example.caso.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.caso.entity.Editoriales;
import com.example.caso.repository.RepositoryEditoriales;
import com.example.caso.services.interfase.EditorialesService;

import jakarta.transaction.Transactional;

@Service ("editorialServiceImpl")
@Transactional
public class EditorialServiceImplement implements EditorialesService {
    
    @Autowired
    @Qualifier ("editorialRepository")
    private RepositoryEditoriales editorialrepository;

    @Override
    public List<Editoriales> listAllEditoriales() {

        return (List<Editoriales>) editorialrepository.findAll();
    }

    @Override
    public Optional<Editoriales> findByIdEditoral(long id) {

        return editorialrepository.findById(id);
    }

    @Override
    public Editoriales updateEditorial(Editoriales editoriales) {

        return editorialrepository.save(editoriales);
    }

    @Override
    public void deleteEditorial(long id) {

        editorialrepository.deleteById(id);
    }

    @Override
    public Editoriales create(Editoriales editoriales) {

        return editorialrepository.save(editoriales);
    }

}
