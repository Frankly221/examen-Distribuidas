package com.example.demo.Entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Libro {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int IDLibro;

    private int ISBN;

    private String Titulo;

    private String Autor;

    private int Año;

    private double Precio;

    private String Comentario;

    private String Foto;

    //Libro jala Registro de propiedad
    @OneToOne
    private RegistroPropiedad registroPropiedad;
    
    
    @ManyToOne
    @JoinColumn(name = "IDEditorial") 
    private Editorial editorial;


     @OneToMany(mappedBy = "libro")
    private List<Inventario> inventario;

    public Libro(int ISBN, String Titulo, String Autor, int Año, double Precio, String Comentario, String Foto) {
        this.ISBN = ISBN;
        this.Titulo = Titulo;
        this.Autor = Autor;
        this.Año = Año;
        this.Precio = Precio;
        this.Comentario = Comentario;
        this.Foto = Foto;
    }
    
}
