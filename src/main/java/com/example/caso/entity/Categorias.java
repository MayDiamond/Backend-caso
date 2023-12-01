package com.example.caso.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "CATEGORIAS")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class Categorias {

    @Id
    @Column (name = "ID_CATEGORIA")
    @GeneratedValue (strategy = GenerationType.SEQUENCE,  generator = "seqCategoria")
    @SequenceGenerator (name = "seqCategoria", allocationSize = 1, sequenceName = "SEQ_CATEGORIA")
    @Builder.Default
    private long id = 0L;
    
    @Column (name = "CATEGORIA")
    private String categoria;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "categorias")
	@JsonIgnore
	private Set<Libros> libros;

    public Categorias (Long id) {
        this.id = id;
    }
}
