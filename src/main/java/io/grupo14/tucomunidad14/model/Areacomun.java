package io.grupo14.tucomunidad14.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;


@Entity
@Table(name = "areacomuns")
public class Areacomun {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idarea;
    private String nombre;
    private @Future Date fecha;
    private Boolean Ocupado;
    private Tipodearea tipodearea;
    @ManyToOne
    @JoinColumn(name = "comunidad_id")
    private Comunidad comunidad;
    @ManyTomany
    @JoinTable(
        name= "Reservas",
        joinColumns = @JoinColumn(name= "comunidad_id",referencedColumnName = "idarea"),
        inverseJoinColumns = @JoinColumn(name = "vecino_id",referencedColumnName = "id")
        
    )
    private List<Vecino> vecinos;

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

    public void setIdarea(Long idarea) {
        this.idarea = idarea;
    }

    public Tipodearea getTipodearea() {
        return tipodearea;
    }

    public void setTipodearea(Tipodearea tipodearea) {
        this.tipodearea = tipodearea;
    }

    public List<Vecino> getVecino() {
        return vecinos;
    }

    public void setVecino(List<Vecino> vecinos) {
        this.vecinos = vecinos;
    }

    public List<Vecino> getVecinos() {
        return vecinos;
    }

    public void setVecinos(List<Vecino> vecinos) {
        this.vecinos = vecinos;
    }

    

}
