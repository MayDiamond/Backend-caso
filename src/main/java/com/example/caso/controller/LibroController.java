package com.example.caso.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.caso.entity.Libros;
import com.example.caso.services.impl.LibroServiceImplement;

@RestController
@RequestMapping ("/libro")
public class LibroController {

    @Autowired
    @Qualifier ("libroServiceImpl")
    private LibroServiceImplement libroService;

    @GetMapping (path = "/listar/", produces = {"application/json"})
    public List <Libros> listarLibros (){

        return libroService.listAllLibros(); 
        
    }

    @GetMapping (path = "/get/{id}", produces = {"application/json"})
    public Optional <Libros> obtenerId (@PathVariable Long id) {
        return libroService.findByIdLibros(id);
    }

    @PutMapping (path = "/guardar/", produces = {"application/json"})
    public Libros guardarLibrps (@RequestBody Libros libros) {
        return libroService.updateLibros(libros);
    }

    @DeleteMapping (path = "/eliminar/{id}", produces = {"application/json"})
    public void eliminarlibro(@PathVariable Long id) {
       libroService.deleteLibro(id);
    }

    @PostMapping (path = "/add/", produces = {"application/json"})
    public ResponseEntity <Libros> crear (@Validated @RequestBody Libros libros) {
        try {
            Libros libros2 = libroService.create(libros);
            return new ResponseEntity<Libros>(libros2,HttpStatus.CREATED);            
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
