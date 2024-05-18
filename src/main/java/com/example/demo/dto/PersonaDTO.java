package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;

public class PersonaDTO {

    @NotBlank
    private String nombre;

    @NotBlank
    private String apellidos;

    public PersonaDTO( String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public PersonaDTO() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
}
