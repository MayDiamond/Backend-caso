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

import com.example.caso.entity.Categorias;
import com.example.caso.services.impl.CategoriaServiceImplement;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = "*")
public class CategoriasController {

    @Autowired
    @Qualifier("categoriaServiceImpl")
    private CategoriaServiceImplement categoriaService;

    @GetMapping(path = "/listar/", produces = { "application/json" })
    public List<Categorias> listarCategorias() {

        return categoriaService.listAllCategorias();

    }

    @GetMapping(path = "/get/{id}", produces = { "application/json" })
    public Optional<Categorias> obtenerId(@PathVariable Long id) {
        return categoriaService.findByIdCategoria(id);
    }

    @PutMapping(path = "/guardar/", produces = { "application/json" })
    public Categorias guardarAutor(@RequestBody Categorias categorias) {
        return categoriaService.updateCategoria(categorias);
    }

    @DeleteMapping(path = "/eliminar /{id}", produces = { "application/json" })
    public void eliminarcategoria(@PathVariable Long id) {
        categoriaService.deleteCategoria(id);
    }

    @PostMapping(path = "/add/", produces = { "application/json" })
    public ResponseEntity<Categorias> crear(@Validated @RequestBody Categorias categorias) {
        try {
            Categorias categorias2 = categoriaService.create(categorias);
            return new ResponseEntity<Categorias>(categorias2, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
