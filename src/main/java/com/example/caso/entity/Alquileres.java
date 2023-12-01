package com.example.caso.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "ALQUILERES")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Alquileres {

    @Id
    @Column (name = "ID_ALQUILERES")
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "SeqAlquiler")
    @SequenceGenerator (name = "SeqAlquiler", allocationSize = 1, sequenceName = "SEQ_ALQUILER")
    @Builder.Default
    private long id = 0L;

    @Column (name = "FECHA_SAL")
    private Date fecha_sal;

    @Column (name = "FECHA_ENTRADA")
    private Date fecha_entrada;

    @ManyToOne
    @JoinColumn(name="DNI_LECTOR", nullable = false)
    private Lectores lectores;
  	
  	@ManyToOne
    @JoinColumn(name="ID_LIBRO", nullable = false)
    private Libros libros;
    
}
