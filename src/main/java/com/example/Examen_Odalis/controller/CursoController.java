/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Examen_Odalis.controller;

import com.example.Examen_Odalis.model.Curso;
import com.example.Examen_Odalis.service.CursoService;
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
@RequestMapping("/api/curso")
public class CursoController {
     @Autowired
    CursoService cursoservice;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Curso>> listar(){
        return new ResponseEntity<>(cursoservice.findByAll(),HttpStatus.OK);
    }
    
    @PostMapping("/crear")
    public String crear(@RequestBody Curso u){
    String mensaje =""; 
        if (u.getNombre().equals("")) {
            mensaje="No campos vacios";
            
        } else {
            mensaje="Corriendo"; 
            cursoservice.crear(u);
        }
        return mensaje;
}
    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Curso> eliminar(@PathVariable  Long id){
        cursoservice.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Curso> buscar(@PathVariable Long id){
        return new ResponseEntity<>(cursoservice.findById(id),HttpStatus.OK);
    }
    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Curso> actualizar(@PathVariable Long id, @RequestBody Curso u){
        Curso casa = buscarusu(id); 
        if (casa == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
            casa.setNombre(u.getNombre());
            casa.setDescripcion(u.getDescripcion());
            casa.setNivel(u.getNivel());
            return new ResponseEntity<>(cursoservice.crear(u),HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
    
    public Curso buscarusu(Long id){
        return cursoservice.findById(id);
    }
}
