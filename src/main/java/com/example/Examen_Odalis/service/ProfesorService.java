/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Examen_Odalis.service;

import com.example.Examen_Odalis.model.Profesor;
import java.util.List;

/**
 *
 * @author Odalis
 */
public interface ProfesorService {
    public Profesor crear(Profesor p);

    public Profesor findById(Long id);

    public List<Profesor> findByAll();

    public void delete(Long id);
}
