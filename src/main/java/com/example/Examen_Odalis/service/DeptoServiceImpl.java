/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Examen_Odalis.service;


import com.example.Examen_Odalis.model.Curso;
import com.example.Examen_Odalis.model.Depto;
import com.example.Examen_Odalis.repository.Cursorepository;
import com.example.Examen_Odalis.repository.Deptorepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Odalis
 */
@Service
public class DeptoServiceImpl implements DeptoService{
    @Autowired
    public Deptorepository deptorepository;

    @Override
    public Depto crear(Depto p) {
         return deptorepository.save(p);
    }

    @Override
    public Depto findById(Long id) {
        return deptorepository.findById(id).orElse(null);
    }

    @Override
    public List<Depto> findByAll() {
        return deptorepository.findAll();
    }

    @Override
    public void delete(Long id) {
        deptorepository.deleteById(id);
    }
  
   
}
