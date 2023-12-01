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

import com.example.caso.entity.Lectores;
import com.example.caso.services.impl.LectorServiceImplement;

@RestController
@RequestMapping("/lector")
@CrossOrigin(origins = "*")
public class LectoresController {

    @Autowired
    @Qualifier ("lectorServiceImpl")
    private LectorServiceImplement lectorService;

    @GetMapping (path = "/listar/", produces = {"application/json"})
    public List <Lectores> listaEditoriales (){

        return lectorService.listAllLectores(); 
        
    }

    @GetMapping (path = "/get/{id}", produces = {"application/json"})
    public Optional <Lectores> obtenerId (@PathVariable Long id) {
        return lectorService.findByIdLector(id);
    }

    @PutMapping (path = "/guardar/", produces = {"application/json"})
    public Lectores guardarLectores (@RequestBody Lectores lectores) {
        return lectorService.updateLectores(lectores);
    }

    @DeleteMapping (path = "/eliminar /{id}", produces = {"application/json"})
    public void eliminarlector(@PathVariable Long id) {
       lectorService.deleteLector(id);
    }

    @PostMapping (path = "/add/", produces = {"application/json"})
    public ResponseEntity <Lectores> crear (@Validated @RequestBody Lectores lectores) {
        try {
            Lectores lectores2 = lectorService.create(lectores);
            return new ResponseEntity<Lectores>(lectores2,HttpStatus.CREATED);            
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }


    
}
