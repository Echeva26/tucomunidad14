package io.grupo14.tucomunidad14.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "COMUNIDAD")
public class Comunidad {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idcomunidad;

    @NotNull(message = "El código postal no puede ser nulo")
    private Integer codpostal;

    @NotNull(message = "El nombre no puede ser nulo")
    private String nombre;

    @OneToMany(mappedBy = "comunidad", fetch = jakarta.persistence.FetchType.LAZY, cascade = jakarta.persistence.CascadeType.ALL)
    private List<Vecino> vecinos;

    @OneToMany(mappedBy = "comunidad", fetch = jakarta.persistence.FetchType.LAZY, cascade = jakarta.persistence.CascadeType.ALL)
    private List<Areacomun> areas;

    @OneToMany(mappedBy = "comunidad", fetch = jakarta.persistence.FetchType.LAZY, cascade = jakarta.persistence.CascadeType.ALL)
    private List<Informacion> informacions;

    // Constructor
    public Comunidad() {
    }

    // Getters y setters
    public Long getIdcomunidad() {
        return idcomunidad;
    }

    public void setIdcomunidad(Long idcomunidad) {
        this.idcomunidad = idcomunidad;
    }

    public Integer getCodpostal() {
        return codpostal;
    }

    public void setCodpostal(Integer codpostal) {
        this.codpostal = codpostal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Vecino> getVecinos() {
        return vecinos;
    }

    public void setVecinos(List<Vecino> vecinos) {
        this.vecinos = vecinos;
    }

    public List<Areacomun> getAreas() {
        return areas;
    }

    public void setAreas(List<Areacomun> areas) {
        this.areas = areas;
    }

    public List<Informacion> getInformacions() {
        return informacions;
    }

    public void setInformacions(List<Informacion> informacions) {
        this.informacions = informacions;
    }
}
