package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LibroDTO;
import com.example.demo.entity.Libro;
import com.example.demo.service.ServiceLibro;


@RestController
@RequestMapping("/libro")
@CrossOrigin(origins = "http://localhost:4200")
public class ControllerLibro {

    @Autowired
    ServiceLibro serviceLibro;

     @GetMapping("/obtener")
    public ResponseEntity<List<Libro>> list (){

        List<Libro> libro = serviceLibro.Lista();

        return new ResponseEntity<>(libro, HttpStatus.OK);
    }


     @GetMapping("/obtenerUno/{id}")
    public ResponseEntity<Optional<Libro>> getUnLibro(@PathVariable("id") int id){
        
        Optional<Libro> libro =  serviceLibro.ObtenerUno(id);

        return new ResponseEntity<>(libro, HttpStatus.OK); 

    }


     @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody LibroDTO libroDTO) {

        Libro libro= new Libro(

        libroDTO.getISBN(),
     libroDTO.getTitulo(),
     libroDTO.getAutor(),
     libroDTO.getAño(),
     libroDTO.getPrecio(),
     libroDTO.getComentario(),
     libroDTO.getFoto()
        );


        serviceLibro.save(libro);

        return new ResponseEntity<>(HttpStatus.OK);  



    }



    
}
