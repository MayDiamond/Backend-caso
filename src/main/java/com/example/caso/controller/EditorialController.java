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

import com.example.caso.entity.Editoriales;
import com.example.caso.services.impl.EditorialServiceImplement;

@RestController
@RequestMapping("/editorial")
@CrossOrigin(origins = "*")
public class EditorialController {

        @Autowired
    @Qualifier ("editorialServiceImpl")
    private EditorialServiceImplement editorialService;

    @GetMapping (path = "/listar/", produces = {"application/json"})
    public List <Editoriales> listaEditoriales (){

        return editorialService.listAllEditoriales();
        
    }

    @GetMapping (path = "/get/{id}", produces = {"application/json"})
    public Optional <Editoriales> obtenerId (@PathVariable Long id) {
        return editorialService.findByIdEditoral(id);
    }

    @PutMapping (path = "/guardar/", produces = {"application/json"})
    public Editoriales guardarEditoriales (@RequestBody Editoriales editoriales) {
        return editorialService.updateEditorial(editoriales);
    }

    @DeleteMapping (path = "/eliminar /{id}", produces = {"application/json"})
    public void eliminareditorial(@PathVariable Long id) {
       editorialService.deleteEditorial(id);
    }

    @PostMapping (path = "/add/", produces = {"application/json"})
    public ResponseEntity <Editoriales> crear (@Validated @RequestBody Editoriales editoriales) {
        try {
            Editoriales editoriales2 = editorialService.create(editoriales);
            return new ResponseEntity<Editoriales>(editoriales2,HttpStatus.CREATED);            
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
    
}
