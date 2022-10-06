/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Examen_Odalis.repository;

import com.example.Examen_Odalis.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Odalis
 */
public interface Cursorepository extends JpaRepository<Curso, Long>{
    
}
