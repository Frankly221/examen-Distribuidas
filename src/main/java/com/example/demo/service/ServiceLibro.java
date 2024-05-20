package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Libro;
import com.example.demo.repository.RepoLibro;

import jakarta.transaction.Transactional;


@Service
@Transactional

public class ServiceLibro {

    @Autowired
    RepoLibro repoLibro;

     public List<Libro> Lista(){
         return repoLibro.findAll();
     }

     public Optional<Libro> ObtenerUno(int id){

        return repoLibro.findById(id);
     }

      public void save(Libro libro){

        repoLibro.save(libro);
    }

    public void delete(int id){
        repoLibro.deleteById(id);
    }
    
}
