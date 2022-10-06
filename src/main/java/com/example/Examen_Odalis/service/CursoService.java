/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Examen_Odalis.service;

import com.example.Examen_Odalis.model.Curso;
import java.util.List;

/**
 *
 * @author Odalis
 */
public interface CursoService {
     public Curso crear(Curso p);

    public Curso findById(Long id);

    public List<Curso> findByAll();

    public void delete(Long id);
}
