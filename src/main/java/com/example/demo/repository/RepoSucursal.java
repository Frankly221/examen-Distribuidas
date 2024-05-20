package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Sucursal;

@Repository

public interface  RepoSucursal extends JpaRepository<Sucursal , Integer> {

    // Optional<Editorial> findBySucursal(String Sucursal);
    
}
