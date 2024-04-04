package io.grupo14.tucomunidad14.model;


import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;

@Entity
@Table(name= "vecinos")
public class Vecino {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String apellidos;
    private @Email String email;
    private Integer portal;
    private Integer piso;
    private Integer telefono;
    private Boolean gestor;
    @ManyToOne
    @JoinColumn(name = "comunidad_id")
    private Comunidad comunidad;
    @ManyToMany(mappedBy = "Vecinos")
    private ArrayList <Areacomun> areas;


    public Vecino() {
        
    }
    
    public ArrayList<Areacomun> getArea() {
        return areas;
    }

    public void setArea(ArrayList <Areacomun> areas) {
        this.areas = areas;
    }

    public Boolean getGestor() {
        return gestor;
    }

    public void setGestor(Boolean gestor) {
        this.gestor = gestor;
    }

    public Comunidad getComunidad() {
        return comunidad;
    }

    public void setComunidad(Comunidad comunidad) {
        this.comunidad = comunidad;
    }

    public Long getId() {
        return id;
    }
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Integer getPortal() {
        return portal;
    }
    public void setPortal(Integer portal) {
        this.portal = portal;
    }
    public Integer getPiso() {
        return piso;
    }
    public void setPiso(Integer piso) {
        this.piso = piso;
    }
    public Integer getTelefono() {
        return telefono;
    }
    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }
}
