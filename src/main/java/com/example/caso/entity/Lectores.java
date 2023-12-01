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
@Table (name = "LECTORES") 
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Lectores {

    @Id
    @Column (name = "DNI_LECTOR")
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "seqLector")
    @SequenceGenerator (name = "seqLector", allocationSize = 1, sequenceName = "SEQ_LECTOR")
    @Builder.Default
    private long id =0L;

    @Column (name = "NOMBRE")
    private String nombre;

    @Column (name = "TELEFONO")
    private int telefono;

    @Column (name = "DIRECCION")
    private String direccion;

    @Column (name = "CODIGOPOSTAL")
    private String codigopostal;

    @Column (name = "OBSERVACIONES")
    private String observaciones;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "lectores")
	@JsonIgnore
	private Set<Alquileres> alquileres;
    
    
}
