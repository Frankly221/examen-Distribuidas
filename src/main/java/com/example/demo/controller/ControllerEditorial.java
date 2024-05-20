package com.example.demo.Controller;

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

import com.example.demo.DTO.EditorialDTO;
import com.example.demo.Entity.Editorial;
import com.example.demo.service.ServiceEditorial;



@RestController
@RequestMapping("/editorial")
@CrossOrigin(origins = "http://localhost:4200")

public class ControllerEditorial {

    @Autowired
    ServiceEditorial serviceEditorial;

    @GetMapping("/obtener")
    public ResponseEntity<List<Editorial>> list (){

        List<Editorial> list = serviceEditorial.list();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/obtenerUno/{id}")
    public ResponseEntity<Optional<Editorial>> getUnEditorial(@PathVariable("id") int id){
        
        Optional<Editorial> editorial =  serviceEditorial.UnaPersona(id);

        return new ResponseEntity<>(editorial, HttpStatus.OK); 

    }

    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody EditorialDTO editorialDTO) {

        Editorial editoral = new Editorial(
            editorialDTO.getTelefono(),
            editorialDTO.getNombreDelContacto(),
            editorialDTO.getDireccion(),
            editorialDTO.getCiudad(),
            editorialDTO.getEmail(),
            editorialDTO.getEditorial(),
            editorialDTO.getComentario()

        );

        serviceEditorial.save(editoral);

        return new ResponseEntity<>(HttpStatus.OK);   
    }




    @PutMapping("/editar/{id}")
    public ResponseEntity<?> edit(@PathVariable("id") int id, @RequestBody EditorialDTO editorialDTO) {
        // Buscar la editorial existente por su ID
        Optional<Editorial> optionalEditorial = serviceEditorial.UnaPersona(id);
        
        // Verificar si la editorial existe
        if (optionalEditorial.isPresent()) {
            // Actualizar los campos de la editorial existente con los valores proporcionados en editorialDTO
            Editorial editorialExistente = optionalEditorial.get();
            editorialExistente.setTelefono(editorialDTO.getTelefono());
            editorialExistente.setNombreDelContacto(editorialDTO.getNombreDelContacto());
            editorialExistente.setDireccion(editorialDTO.getDireccion());
            editorialExistente.setCiudad(editorialDTO.getCiudad());
            editorialExistente.setEmail(editorialDTO.getEmail());
            editorialExistente.setEditorial(editorialDTO.getEditorial());
            editorialExistente.setComentario(editorialDTO.getComentario());
            
            // Guardar la editorial actualizada en la base de datos
            serviceEditorial.save(editorialExistente);
    
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            // La editorial no existe, devolver un error 404 Not Found
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){

        serviceEditorial.delete(id);
         
        return new ResponseEntity<>(HttpStatus.OK);
    }
    









    
}
