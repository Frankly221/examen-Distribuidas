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

import com.example.demo.dto.SucursalDTO;
import com.example.demo.entity.Sucursal;
import com.example.demo.service.ServiceSucursal;

public class ControllerSucursal {


    @RestController
@RequestMapping("/sucursal")
@CrossOrigin(origins = "http://localhost:4200")

public class ControllerEditorial {

    @Autowired
    ServiceSucursal serviceSucursal;

    @GetMapping("/obtener")
    public ResponseEntity<List<Sucursal>> list (){

        List<Sucursal> list = serviceSucursal.Lista();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/obtenerUno/{id}")
    public ResponseEntity<Optional<Sucursal>> getUnEditorial(@PathVariable("id") int id){
        
        Optional<Sucursal> sucursal =  serviceSucursal.ObtenerUno(id);

        return new ResponseEntity<>(sucursal, HttpStatus.OK); 

    }

    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody SucursalDTO sucursalDTO) {

        Sucursal sucursal = new Sucursal(
            sucursalDTO.getSucursal(),
            sucursalDTO.getNombreDelEncargado(),
            sucursalDTO.getDireccion(),
            sucursalDTO.getCiudad(),
            sucursalDTO.getTelefono(),
            sucursalDTO.getEmail(),
            sucursalDTO.getComentario()
            );
        
            
          

        serviceSucursal.save(sucursal);

        return new ResponseEntity<>(HttpStatus.OK);   
    }




    @PutMapping("/editar/{id}")
    public ResponseEntity<?> edit(@PathVariable("id") int id, @RequestBody SucursalDTO sucursalDTO) {
        // Buscar la editorial existente por su ID
        Optional<Sucursal> optionalSucursal = serviceSucursal.ObtenerUno(id);
        
        // Verificar si la editorial existe
        if (optionalSucursal.isPresent()) {
            // Actualizar los campos de la editorial existente con los valores proporcionados en editorialDTO
            Sucursal sucursalExistente = optionalSucursal.get();
            sucursalExistente.setSucursal(sucursalDTO.getSucursal());
            sucursalExistente.setNombreDelEncargado(sucursalDTO.getNombreDelEncargado());
            sucursalExistente.setDireccion(sucursalDTO.getDireccion());
            sucursalExistente.setCiudad(sucursalDTO.getCiudad());
            sucursalExistente.setTelefono(sucursalDTO.getTelefono());
            sucursalExistente.setEmail(sucursalDTO.getEmail());
            sucursalExistente.setComentario(sucursalDTO.getComentario());

            
            
            // Guardar la sucursal actualizada en la base de datos
            serviceSucursal.save( sucursalExistente);
    
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            // La  sucursal no existe, devolver un error 404 Not Found
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){

        serviceSucursal.delete(id);
         
        return new ResponseEntity<>(HttpStatus.OK);
    }
    




    
} 
}
