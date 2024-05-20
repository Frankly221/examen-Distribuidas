package com.example.demo.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor

public class SucursalDTO {

    @NotBlank
    private String Sucursal;

    @NotBlank
    private String NombreDelEncargado;

    @NotBlank
    private String Direccion;

    @NotBlank
    private String Ciudad;

    @NotBlank
    private int Telefono;

    private String Email;

    private String Comentario;


    
}
