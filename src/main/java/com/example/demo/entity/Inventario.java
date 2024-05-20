package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Inventario {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int IDEnvetario;

    private int IDLibro;

    private int IDSucursal;

    private int Existencia;


    @ManyToOne
    private Libro libro;

    @ManyToOne
    private Sucursal sucursal;
    
}
