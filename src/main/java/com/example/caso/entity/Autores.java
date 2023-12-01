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
@Table (name = "AUTORES")
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Data

public class Autores {

    @Id
    @Column (name = "ID_AUTOR")
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "seqAutores")
    @SequenceGenerator (name = "seqAutores", allocationSize = 1, sequenceName = "SEQ_AUTOR")
    @Builder.Default
    private long id = 0L;

    @Column (name = "AUTOR")
    private String autor;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "autores")
	@JsonIgnore
	private Set<Libros> libros;

    public Autores (Long id) {
        this.id = id;
    }

}
