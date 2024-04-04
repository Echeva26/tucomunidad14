package io.grupo14.tucomunidad14.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;



@Entity
@Table(name= "areacomuns")
public class Areacomun {
     @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idarea;
    private String nombre;
    private @Future Date fecha;
    private Boolean Ocupado;
    @ManyToOne 
    private Comunidad comunidad;
    @ManyToOne
    private Vecino vecino;

    


    public Areacomun() {

    }

    
    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public Long getIdarea() {
        return idarea;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Boolean getOcupado() {
        return Ocupado;
    }
    public void setOcupado(Boolean ocupado) {
        Ocupado = ocupado;
    }
    public Comunidad getComunidad() {
        return comunidad;
    }
    public void setComunidad(Comunidad comunidad) {
        this.comunidad = comunidad;
    }
    public Vecino getVecino() {
        return vecino;
    }
    public void setVecino(Vecino vecino) {
        this.vecino = vecino;
    }

    
}
