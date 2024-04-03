package io.grupo14.tucomunidad14.model;



import org.hibernate.mapping.List;

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
    //@OneToMany(mappedBy = "comunidad")
    



    //Constructor
    public Comunidad(Long id, Integer codpostal) {
        this.id = id;
        this.codpostal = codpostal;
    }

    //Getters y setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Integer getCodpostal() {
        return codpostal;
    }
    public void setCodpostal(Integer codpostal) {
        this.codpostal = codpostal;
    }

    
}
