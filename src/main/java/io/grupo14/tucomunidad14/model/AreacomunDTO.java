
package io.grupo14.tucomunidad14.model;

public class AreacomunDTO {
    private String nombre;
    private int tipodearea; // Cambio aquí de Tipodearea a int
    private Long idComunidad; // Utilizar este campo para recibir el ID de la comunidad

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Cambio el getter y setter para manejar un int
    public int getTipodearea() {
        return tipodearea;
    }

    public void setTipodearea(int tipodearea) {
        this.tipodearea = tipodearea;
    }

    public Long getIdComunidad() {
        return idComunidad;
    }

    public void setIdComunidad(Long idComunidad) {
        this.idComunidad = idComunidad;
    }
}
