package io.grupo14.tucomunidad14.model;

import java.sql.Date;
import java.util.List;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name= "INFORMACION")
public class Informacion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idinformacion;
    private String titulo;
    private Date fecha;
    private Object foto;//Cambios?
    private String descripcion;
    private String textocompleto;//Cambios?
    
    @ManyToMany(mappedBy = "informacions")
    private List<Vecino> vecinos;
    @ManyToOne
    @JoinColumn(name = "comunidad")
    private Comunidad comunidad;
    // Campo para el inicio de la reserva
    


    public Long getIdinformacion() {
        return idinformacion;
    }
    public Informacion() {
    }
    public void setIdinformacion(Long idinformacion) {
        this.idinformacion = idinformacion;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Object getFoto() {
        return foto;
    }
    public void setFoto(Object foto) {
        this.foto = foto;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getTextocompleto() {
        return textocompleto;
    }
    public void setTextocompleto(String textocompleto) {
        this.textocompleto = textocompleto;
    }
    public List<Vecino> getVecino() {
        return vecinos;
    }
    public void setVecino(List<Vecino> vecinos) {
        this.vecinos = vecinos;
    }
    public Comunidad getComunidad() {
        return comunidad;
    }
    public void setComunidad(Comunidad comunidad) {
        this.comunidad = comunidad;
    }
    
    
    

    
}

