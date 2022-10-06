/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Examen_Odalis.controller;

import com.example.Examen_Odalis.model.Curso;
import com.example.Examen_Odalis.model.Depto;
import com.example.Examen_Odalis.service.CursoService;
import com.example.Examen_Odalis.service.DeptoService;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Odalis
 */
@RestController
@RequestMapping("/api/depto")
public class DeptoController {
         @Autowired
    DeptoService deptoservice;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Depto>> listar(){
        return new ResponseEntity<>(deptoservice.findByAll(),HttpStatus.OK);
    }
    
    @PostMapping("/crear")
    public String crear(@RequestBody Depto u){
    String mensaje =""; 
        if (u.getNombre().equals("")) {
            mensaje="No campos vacios";
            
        } else {
            mensaje="Corriendo"; 
            deptoservice.crear(u);
        }
        return mensaje;
}
    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Depto> eliminar(@PathVariable  Long id){
        deptoservice.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Depto> buscar(@PathVariable Long id){
        return new ResponseEntity<>(deptoservice.findById(id),HttpStatus.OK);
    }
    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Depto> actualizar(@PathVariable Long id, @RequestBody Depto u){
        Depto casa = buscarusu(id); 
        if (casa == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
            casa.setNombre(u.getNombre());
            casa.setDescrip(u.getDescrip());
           
            return new ResponseEntity<>(deptoservice.crear(u),HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
    
    public Depto buscarusu(Long id){
        return deptoservice.findById(id);
    }
}
