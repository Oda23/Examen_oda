/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Examen_Odalis.service;


import com.example.Examen_Odalis.model.Depto;
import java.util.List;

/**
 *
 * @author Odalis
 */
public interface DeptoService {
    public Depto crear(Depto p);

    public Depto findById(Long id);

    public List<Depto> findByAll();

    public void delete(Long id);
}
