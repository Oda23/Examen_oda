/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Examen_Odalis.service;

import com.example.Examen_Odalis.model.Profesor;
import com.example.Examen_Odalis.repository.Profesorrepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Odalis
 */
@Service
public class ProfesorServiceImpl implements ProfesorService {
    @Autowired
    public Profesorrepository profesorrepository;

    @Override
    public Profesor crear(Profesor p) {
         return profesorrepository.save(p);
    }

    @Override
    public Profesor findById(Long id) {
        return profesorrepository.findById(id).orElse(null);
    }

    @Override
    public List<Profesor> findByAll() {
        return profesorrepository.findAll();
    }

    @Override
    public void delete(Long id) {
        profesorrepository.deleteById(id);
    }
}
