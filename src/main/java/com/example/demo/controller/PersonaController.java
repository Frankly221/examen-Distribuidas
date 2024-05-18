package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PersonaDTO;
import com.example.demo.entity.Mensaje;
import com.example.demo.entity.Persona;
import com.example.demo.service.ServicePersona;

@RestController
@RequestMapping("/persona")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {

    @Autowired
    ServicePersona servicePersona;

    @GetMapping("/all")
    public ResponseEntity<List<Persona>> list(){
        List<Persona> list = servicePersona.list();

        return new ResponseEntity<>(list, HttpStatus.OK);

    }


    @GetMapping("/one/{id}")
public ResponseEntity<Optional<Persona>> getPersona(@PathVariable("id") int id) {
    Optional<Persona> persona = servicePersona.getPersona(id);
    return new ResponseEntity<>(persona, HttpStatus.OK);
}
          

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody PersonaDTO personaDTO) {

        
        Persona persona = new Persona(
            personaDTO.getNombre(),
             personaDTO.getApellidos());

        servicePersona.save(persona);
        return new ResponseEntity<>(new Mensaje("Persona Creada"), HttpStatus.CREATED);
    }



    @PutMapping("edit/{id}")
    public ResponseEntity<?> edit(@PathVariable("id") int id, @RequestBody PersonaDTO personaDTO){

        Persona persona = servicePersona.getPersona(id).get();
        persona.setNombre(personaDTO.getNombre());
        persona.setApellidos(personaDTO.getApellidos());
        servicePersona.save(persona);

        return new ResponseEntity<>(new Mensaje("persona editada"), HttpStatus.OK);
    
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        servicePersona.delete(id);
        return new ResponseEntity<>(new Mensaje("persona eliminado"), HttpStatus.OK);
    }

    
}
