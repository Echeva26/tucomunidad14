package io.grupo14.tucomunidad14.model;

public class AreacomunDTO {
    private String nombre;
    private Tipodearea tipodearea;
    private Long idComunidad; // Utilizar este campo para recibir el ID de la comunidad
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Tipodearea getTipodearea() {
        return tipodearea;
    }
    public void setTipodearea(Tipodearea tipodearea) {
        this.tipodearea = tipodearea;
    }
    public Long getIdComunidad() {
        return idComunidad;
    }
    public void setIdComunidad(Long idComunidad) {
        this.idComunidad = idComunidad;
    }

   
}

