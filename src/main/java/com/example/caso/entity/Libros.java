package com.example.caso.entity;

import java.sql.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "LIBROS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Libros {

    @Id
    @Column (name = "ID_LIBRO")
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "seqLibros")
    @SequenceGenerator (name = "seqLibros", allocationSize = 1, sequenceName = "SEQ_LIBRO")
    @Builder.Default
    private long id = 0L;

    @Column (name = "TITULO")
    private String titulo;

    @Column (name = "FECHA_LANZA")
    private Date fecha_lanza;

    @Column (name = "IDIOMA")
    private String idioma;

    @Column (name = "PAGINAS")
    private Integer paginas;

    @Column (name = "DESCRIPCION")
    private String descripcion;

    @Column (name = "PORTADA")
    private String portada;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "libros")
	  @JsonIgnore
	private Set<Alquileres> alquileres;
  	
  	@ManyToOne
    @JoinColumn(name="ID_AUTOR", nullable = false)
    private Autores autores;

  	@ManyToOne
    @JoinColumn(name="ID_CATEGORIA", nullable = false)
    private Categorias categorias;
  	
  	@ManyToOne
    @JoinColumn(name="ID_EDITORIAL", nullable = false)
    private Editoriales editoriales;

    
}
