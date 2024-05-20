package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Libro;

@Repository

public interface  RepoLibro extends JpaRepository<Libro , Integer> {

    //  Optional<Editorial> findByTitulo(String Titulo);
    
}
