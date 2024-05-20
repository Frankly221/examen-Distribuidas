package com.example.demo.entity;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Sucursal {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int IDESucursal;

    private String Sucursal;

    private String NombreDelEncargado;

    private String Direccion;

    private String Ciudad;

    private int Telefono;

    private String Email;

    private String Comentario;


    @OneToMany(mappedBy = "sucursal")
    private List<Inventario> inventario;


    public Sucursal(String sucursal, String nombreDelEncargado, String direccion, String ciudad, int telefono,
            String email, String comentario) {
        Sucursal = sucursal;
        NombreDelEncargado = nombreDelEncargado;
        Direccion = direccion;
        Ciudad = ciudad;
        Telefono = telefono;
        Email = email;
        Comentario = comentario;
    }
    
}
