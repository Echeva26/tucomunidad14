package io.grupo14.tucomunidad14.model;

import jakarta.validation.constraints.Email;

public class ComunidadDTO {
    private Long idcomunidad;
    private String nombre;
    private Integer codpostal;
    private @Email String email;

    
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


    
}
