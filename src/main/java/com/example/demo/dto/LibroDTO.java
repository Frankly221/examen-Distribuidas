package com.example.demo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor

public class LibroDTO {

    @NotBlank
    private int ISBN;

    @NotBlank
    private String Titulo;

    @NotBlank
    private String Autor;

    @NotBlank
    private int Año;

    @NotBlank
    @Min(value = 1)
    private double Precio;


    private String Comentario;

    
    private String Foto;

    
}
