/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Examen_Odalis.service;

import com.example.Examen_Odalis.model.Curso;
import com.example.Examen_Odalis.repository.Cursorepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Odalis
 */
@Service
public class CursoServiceImpl implements CursoService{

    @Autowired
    public Cursorepository cursorepository;

    @Override
     public Curso crear(Curso p) {
        return cursorepository.save(p);
    }

    @Override
    public Curso findById(Long id) {
        return cursorepository.findById(id).orElse(null);
    }

    @Override
    public List<Curso> findByAll() {
        return cursorepository.findAll();
    }

    @Override
    public void delete(Long id) {
        cursorepository.deleteById(id);
    }
    
    
}
