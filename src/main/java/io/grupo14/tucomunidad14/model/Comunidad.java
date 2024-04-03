package io.grupo14.tucomunidad14.model;

import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;



@Entity
@Table(name= "comunidads")
public class Comunidad {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer codpostal;
    @OneToMany(mappedBy = "comunidad")
    private ArrayList<Vecino> vecinos;
    @OneToMany(mappedBy = "comunidad")
    private ArrayList<Areacomun> area;
    



    //Constructor
    public Comunidad() {
        
    }

    //Getters y setters
    public Long getId() {
        return id;
    }
    public ArrayList<Vecino> getVecinos() {
        return vecinos;
    }

    public ArrayList<Areacomun> getArea() {
        return area;
    }

    public Integer getCodpostal() {
        return codpostal;
    }
    public void setCodpostal(Integer codpostal) {
        this.codpostal = codpostal;
    }

    
}
