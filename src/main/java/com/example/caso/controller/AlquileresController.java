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

import com.example.caso.entity.Alquileres;
import com.example.caso.services.impl.AlquilerServiceImplement;

@RestController
@RequestMapping ("/alquiler")
@CrossOrigin (origins = "*")
public class AlquileresController {
    
    @Autowired
    @Qualifier ("alquilerServiceImpl")
    private AlquilerServiceImplement alquilerService;

    @GetMapping (path = "/listar/", produces = {"application/json"})
    public List <Alquileres> listarAlquileres (){

        return alquilerService.listAllaquileres();
        
    }

    @GetMapping (path = "/get/{id}", produces = {"application/json"})
    public Optional <Alquileres> obtenerId (@PathVariable Long id) {
        return alquilerService.findByIdAlquileres(id);
    }

    @PutMapping (path = "/guardar/", produces = {"application/json"})
    public Alquileres guardarAlquiler (@RequestBody Alquileres alquileres) {
        return alquilerService.updateAlquileres(alquileres);
    }

    @DeleteMapping (path = "/eliminar /{id}", produces = {"application/json"})
    public void eliminarAlquiler (@PathVariable Long id) {
        alquilerService.deleteAlquileres(id);
    }

    @PostMapping (path = "/add/", produces = {"application/json"})
    public ResponseEntity <Alquileres> crear (@Validated @RequestBody Alquileres alquileres) {
        try {
            Alquileres alquileres2 = alquilerService.create(alquileres);
            return new ResponseEntity<Alquileres>(alquileres2,HttpStatus.CREATED);            
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR );
        }
    }
}