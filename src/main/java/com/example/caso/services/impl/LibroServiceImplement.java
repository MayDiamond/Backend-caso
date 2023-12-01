package com.example.caso.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.caso.entity.Libros;
import com.example.caso.repository.RepositoryLibros;
import com.example.caso.services.interfase.LibrosServices;

@Service ("libroServiceImpl")
public class LibroServiceImplement implements LibrosServices {

    @Autowired 
    @Qualifier ("libroRepository")
    private RepositoryLibros libroRepository;

    @Override
    public List<Libros> listAllLibros() {
  
        return (List<Libros>) libroRepository.findAll();
    }

    @Override
    public Optional<Libros> findByIdLibros(long id) {

        return libroRepository.findById(id);
    }

    @Override
    public Libros updateLibros(Libros libros) {
        
    return libroRepository.save(libros);
    }

    @Override
    public void deleteLibro(long id) {

        libroRepository.deleteById(id);
    }

    @Override
    public Libros create(Libros libros) {

        return libroRepository.save(libros);
    }
    
}
