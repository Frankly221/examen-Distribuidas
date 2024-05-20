package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Sucursal;
import com.example.demo.repository.RepoSucursal;

import jakarta.transaction.Transactional;



@Service
@Transactional

public class ServiceSucursal {


    @Autowired
    RepoSucursal repoSucursal;

    public List<Sucursal> Lista(){
        
        return repoSucursal.findAll();
    }
        

    public Optional<Sucursal> ObtenerUno(int id){

        return repoSucursal.findById(id);
    }
    
       public void save(Sucursal sucursal){

        repoSucursal.save(sucursal);
    }

    public void delete(int id){
        repoSucursal.deleteById(id);
    }




}
