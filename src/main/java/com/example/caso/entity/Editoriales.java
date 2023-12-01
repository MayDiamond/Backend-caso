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
@Table (name = "EDITORIALES")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Editoriales {

    @Id
    @Column (name = "ID_EDITORIAL")
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "seqEditorial")
    @SequenceGenerator (name = "seqEditorial", allocationSize = 1, sequenceName = "SEQ_EDITORIAL")
    @Builder.Default
    private long id = 0L;

    @Column (name = "EDITORIAL")
    private String editorial;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "editoriales")
	@JsonIgnore
	private Set<Libros> libros;

    public Editoriales (Long id) {
        this.id = id;
    }

    
}
