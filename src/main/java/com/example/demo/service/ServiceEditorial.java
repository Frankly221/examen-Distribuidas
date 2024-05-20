package com.example.demo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Editorial;
import com.example.demo.repository.RepoEditoria;

import jakarta.transaction.Transactional;

@Service
@Transactional

public class ServiceEditorial {

    @Autowired
    RepoEditoria repoEditoria;

    public List<Editorial> list(){

        return repoEditoria.findAll();
    }

    public Optional<Editorial> UnaPersona(int id){

        return repoEditoria.findById(id);
    }    

    
    public void save(Editorial editorial){

        repoEditoria.save(editorial);
    }

    public void delete(int id){
        repoEditoria.deleteById(id);
    }


    
}
