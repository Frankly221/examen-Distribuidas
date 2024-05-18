package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Persona;
import com.example.demo.repository.RepoPersona;

import jakarta.transaction.Transactional;

@Service
@Transactional

public class ServicePersona {

    @Autowired
    RepoPersona repoPersona;

    public List<Persona> list(){
        return repoPersona.findAll();
    }

    public Optional<Persona> getPersona(int id){

        return repoPersona.findById(id);
    }

    public void save(Persona persona){
        repoPersona.save(persona);
    }

    public void delete(int id){

        repoPersona.deleteById(id);
    }

   
    
}
