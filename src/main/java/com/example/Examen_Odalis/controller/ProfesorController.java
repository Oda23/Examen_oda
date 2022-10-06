/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Examen_Odalis.controller;

import com.example.Examen_Odalis.model.Depto;
import com.example.Examen_Odalis.model.Profesor;
import com.example.Examen_Odalis.service.DeptoService;
import com.example.Examen_Odalis.service.ProfesorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author Odalis
 */
public class ProfesorController {
    @Autowired
    ProfesorService profesorservice;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Profesor>> listar(){
        return new ResponseEntity<>(profesorservice.findByAll(),HttpStatus.OK);
    }
    
    @PostMapping("/crear")
    public String crear(@RequestBody Profesor u){
    String mensaje =""; 
        if (u.getNombre().equals("")) {
            mensaje="No campos vacios";
            
        } else {
            mensaje="Corriendo"; 
            profesorservice.crear(u);
        }
        return mensaje;
}
    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Depto> eliminar(@PathVariable  Long id){
        profesorservice.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Profesor> buscar(@PathVariable Long id){
        return new ResponseEntity<>(profesorservice.findById(id),HttpStatus.OK);
    }
    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Profesor> actualizar(@PathVariable Long id, @RequestBody Profesor u){
        Profesor casa = buscarusu(id); 
        if (casa == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
            casa.setNombre(u.getNombre());

           
            return new ResponseEntity<>(profesorservice.crear(u),HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
    
    public Profesor buscarusu(Long id){
        return profesorservice.findById(id);
    }
}


