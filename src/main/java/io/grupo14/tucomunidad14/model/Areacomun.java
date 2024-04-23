package io.grupo14.tucomunidad14.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "AREACOMUN")
public class Areacomun {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idarea;

    @NotNull(message = "El nombre no puede ser nulo")
    private String nombre;

    private Tipodearea tipodearea;

    @ManyToOne
    @JoinColumn(name = "comunidad")
    private Comunidad comunidad;

    @OneToMany(mappedBy = "areacomun", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Reserva> reserva;

    public Areacomun() {
    }

    public Long getIdarea() {
        return idarea;
    }

    public void setIdarea(Long idarea) {
        this.idarea = idarea;
    }

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

    public Comunidad getComunidad() {
        return comunidad;
    }

    public void setComunidad(Comunidad comunidad) {
        this.comunidad = comunidad;
    }

    public List<Reserva> getReserva() {
        return reserva;
    }

    public void setReserva(List<Reserva> reserva) {
        this.reserva = reserva;
    }
}
