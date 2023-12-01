package com.example.caso.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.caso.entity.Autores;
import com.example.caso.repository.RepositoryAutores;
import com.example.caso.services.interfase.AutoresServices;

import jakarta.transaction.Transactional;

@Service ("autorServiceImpl")
@Transactional
public class AutorServiceImplement implements AutoresServices{
    
    @Autowired
    @Qualifier ("autorRepository")
    private RepositoryAutores autorserpository; 

    @Override
    public List <Autores> listAllAutores () {

        return (List<Autores>) autorserpository.findAll();
        
    }

    @Override
    public Optional<Autores> findByIdAutor(long id) {

        return autorserpository.findById(id);

    }

    @Override
    public Autores updateAutores(Autores autores) {

        return autorserpository.save(autores);

    }

    @Override
    public void deleteAutores(long id) {

        autorserpository.deleteById(id);

    }

    @Override
    public Autores create(Autores autores) {

        return autorserpository.save(autores);

    }
}
