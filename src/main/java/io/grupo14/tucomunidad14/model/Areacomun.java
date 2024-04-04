package io.grupo14.tucomunidad14.model;





import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;



@Entity
@Table(name = "areacomuns")
public class Areacomun {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idarea;
    private String nombre;
    private Tipodearea tipodearea;
    @ManyToOne
    @JoinColumn(name = "comunidad_id")
    private Comunidad comunidad;
    @OneToOne
    private Reserva reserva;

    
    
    public Areacomun(String nombre, Tipodearea tipodearea, Comunidad comunidad) {
        this.nombre = nombre;
        this.tipodearea = tipodearea;
        this.comunidad = comunidad;
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

   

    
    

}