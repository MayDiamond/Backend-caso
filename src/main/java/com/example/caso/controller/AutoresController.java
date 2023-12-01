package com.example.caso.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.caso.entity.Autores;
import com.example.caso.services.impl.AutorServiceImplement;

@RestController
@RequestMapping ("/autor")
@CrossOrigin (origins = "*")
public class AutoresController {

    @Autowired
    @Qualifier ("autorServiceImpl")
    private AutorServiceImplement autorService;

    @GetMapping (path = "/listar/", produces = {"application/json"})
    public List <Autores> listarAlquileres (){

        return autorService.listAllAutores();
        
    }

    @GetMapping (path = "/get/{id}", produces = {"application/json"})
    public Optional <Autores> obtenerId (@PathVariable Long id) {
        return autorService.findByIdAutor(id);
    }

    @PutMapping (path = "/guardar/", produces = {"application/json"})
    public Autores guardarAutor (@RequestBody Autores autores) {
        return autorService.updateAutores(autores);
    }

    @DeleteMapping (path = "/eliminar /{id}", produces = {"application/json"})
    public void eliminarAutor (@PathVariable Long id) {
       autorService.deleteAutores(id);
    }

    @PostMapping (path = "/add/", produces = {"application/json"})
    public ResponseEntity <Autores> crear (@Validated @RequestBody Autores autores) {
        try {
            Autores autores2 = autorService.create(autores);
            return new ResponseEntity<Autores>(autores2,HttpStatus.CREATED);            
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
    
}
