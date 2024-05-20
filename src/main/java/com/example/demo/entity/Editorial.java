package com.example.demo.Entity;

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

public class Editorial {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idEditorial;

    private String editorial;

    private String nombreDelContacto;

    private String direccion;

    private String ciudad;

    private int telefono;

    private String email;

    private String comentario;


    @OneToMany(mappedBy = "editorial")
    private List<Libro> libro;

    public Editorial(int telefono, String nombreDelContacto, String direccion, String ciudad, String email, String editorial, String comentario) {
        this.telefono = telefono;
        this.nombreDelContacto = nombreDelContacto;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.email = email;
        this.editorial = editorial;
        this.comentario = comentario;
    }

  
    
}
