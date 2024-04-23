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
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "INFORMACION")
public class Informacion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idinformacion;

    @NotNull(message = "El título no puede ser nulo")
    private String titulo;

    private Date fecha;

    @Lob
    @NotNull(message = "El texto completo no puede ser nulo")
    private String textocompleto;

    private String descripcion;

    // Almacenar la URL o referencia del archivo de la foto
    private String foto;

    @ManyToOne
    @JoinColumn(name = "vecino")
    private Vecino vecino;

    @ManyToOne
    @JoinColumn(name = "comunidad")
    private Comunidad comunidad;

    public Informacion() {
    }

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

    public String getTextocompleto() {
        return textocompleto;
    }

    public void setTextocompleto(String textocompleto) {
        this.textocompleto = textocompleto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Vecino getVecino() {
        return vecino;
    }

    public void setVecino(Vecino vecino) {
        this.vecino = vecino;
    }

    public Comunidad getComunidad() {
        return comunidad;
    }

    public void setComunidad(Comunidad comunidad) {
        this.comunidad = comunidad;
    }
}
