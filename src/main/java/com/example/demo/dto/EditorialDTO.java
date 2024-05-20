package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor

public class EditorialDTO {

    @NotBlank
    private String editorial;

    @NotBlank
    private String nombreDelContacto;

    @NotBlank
    private String direccion;

    @NotBlank
    private String ciudad;

    @NotBlank
    private int telefono;

    private String email;

    private String comentario;
    
}
