/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Examen_Odalis.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Odalis
 */
@Entity
@Table(name = "profesor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profesor.findAll", query = "SELECT p FROM Profesor p"),
    @NamedQuery(name = "Profesor.findByIdprofe", query = "SELECT p FROM Profesor p WHERE p.idprofe = :idprofe"),
    @NamedQuery(name = "Profesor.findByNombre", query = "SELECT p FROM Profesor p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Profesor.findByDire", query = "SELECT p FROM Profesor p WHERE p.dire = :dire"),
    @NamedQuery(name = "Profesor.findByTelefono", query = "SELECT p FROM Profesor p WHERE p.telefono = :telefono")})
public class Profesor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idprofe")
    private Long idprofe;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "dire")
    private String dire;
    @Basic(optional = false)
    @Column(name = "telefono")
    private String telefono;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profId")
    private List<Curso> cursoList;
    @JoinColumn(name = "iddepto", referencedColumnName = "iddepto")
    @ManyToOne(optional = false)
    private Depto iddepto;

    public Profesor() {
    }

    public Profesor(Long idprofe, String nombre, String dire, String telefono, List<Curso> cursoList, Depto iddepto) {
        this.idprofe = idprofe;
        this.nombre = nombre;
        this.dire = dire;
        this.telefono = telefono;
        this.cursoList = cursoList;
        this.iddepto = iddepto;
    }

    public Long getIdprofe() {
        return idprofe;
    }

    public void setIdprofe(Long idprofe) {
        this.idprofe = idprofe;
    }

  

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDire() {
        return dire;
    }

    public void setDire(String dire) {
        this.dire = dire;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @XmlTransient
    public List<Curso> getCursoList() {
        return cursoList;
    }

    public void setCursoList(List<Curso> cursoList) {
        this.cursoList = cursoList;
    }

    public Depto getIddepto() {
        return iddepto;
    }

    public void setIddepto(Depto iddepto) {
        this.iddepto = iddepto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprofe != null ? idprofe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesor)) {
            return false;
        }
        Profesor other = (Profesor) object;
        if ((this.idprofe == null && other.idprofe != null) || (this.idprofe != null && !this.idprofe.equals(other.idprofe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.Examen_Odalis.model.Profesor[ idprofe=" + idprofe + " ]";
    }
    
}
