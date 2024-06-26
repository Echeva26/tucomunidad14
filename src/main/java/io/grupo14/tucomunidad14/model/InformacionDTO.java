package io.grupo14.tucomunidad14.model;

import java.sql.Date;

import jakarta.persistence.Lob;

public class InformacionDTO {

    private Long idinformacion;
    private String titulo;
    private Date fecha;
    private String foto;//Cambios?
    private String descripcion;
    @Lob
    private String textocompleto;//Cambios
    private Long idvecino;
    private Long idcomunidad;


    public Long getIdinformacion() {
        return idinformacion;
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
    public Long getIdvecino() {
        return idvecino;
    }
    public void setIdvecino(Long idvecino) {
        this.idvecino = idvecino;
    }
    public Long getIdcomunidad() {
        return idcomunidad;
    }
    public void setIdcomunidad(Long idcomunidad) {
        this.idcomunidad = idcomunidad;
    }
    public String getFoto() {
        return foto;
    }
    public void setFoto(String foto) {
        this.foto = foto;
    }
    
   

    

}
