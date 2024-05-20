package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Editorial;

@Repository

public interface  RepoEditoria extends JpaRepository<Editorial , Integer> {

    //  Optional<Editorial> findByEditorial(String Editorial);
    
}
