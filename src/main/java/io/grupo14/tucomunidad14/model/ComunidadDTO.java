package io.grupo14.tucomunidad14.model;


public class ComunidadDTO {
    private Long idcomunidad;
    private String nombre;
    private Integer codpostal;

    
    public Long getIdcomunidad() {
        return idcomunidad;
    }
    public void setIdcomunidad(Long idcomunidad) {
        this.idcomunidad = idcomunidad;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Integer getCodpostal() {
        return codpostal;
    }
    public void setCodpostal(Integer codpostal) {
        this.codpostal = codpostal;
    }

    
}