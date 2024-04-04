package io.grupo14.tucomunidad14.model;


import java.util.List;

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
    private List<Vecino> vecinos;
    @OneToMany(mappedBy = "comunidad")
    private List<Areacomun> area;
    



    //Constructor
    

    //Getters y setters
    public Long getId() {
        return id;
    }
    public Comunidad(Integer codpostal) {
        this.codpostal = codpostal;
    }
    public List<Vecino> getVecinos() {
        return vecinos;
    }

    public List<Areacomun> getArea() {
        return  area;
    }

    public Integer getCodpostal() {
        return codpostal;
    }
    public void setCodpostal(Integer codpostal) {
        this.codpostal = codpostal;
    }

    
}
