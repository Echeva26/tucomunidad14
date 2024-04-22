package io.grupo14.tucomunidad14.model;


import java.sql.Date;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;

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
    private byte[] foto;//Cambios?
    private String descripcion;
    @Lob
    private String textocompleto;//Cambios?
    
    @ManyToOne
    @JoinColumn(name="gestor")
    private Vecino gestor;
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
    
    
    public Vecino getVecinos() {
        return gestor;
    }
    public void setVecinos(Vecino gestor) {
        this.gestor =gestor;
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
    
    public Comunidad getComunidad() {
        return comunidad;
    }
    public void setComunidad(Comunidad comunidad) {
        this.comunidad = comunidad;
    }
    public byte[] getFoto() {
        return foto;
    }
    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
    
    
    

    
}

