package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Vehiculo {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String color;
    private String marca;

    @JsonIgnore
    @ManyToOne
    private Persona persona;


    public Vehiculo() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public Persona getPersona() {
        return persona;
    }
    
    
    public void setPersona(Persona persona) {
        this.persona = persona;
    }


}
