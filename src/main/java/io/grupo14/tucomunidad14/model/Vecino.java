package io.grupo14.tucomunidad14.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "VECINO")
public class Vecino {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idvecino;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @NotBlank(message = "Los apellidos no pueden estar vacíos")
    private String apellidos;

    @Email(message = "El email debe ser válido")
    private String email;

    @NotBlank(message = "El nombre de usuario no puede estar vacío")
    private String nombredeusuario;

    @NotBlank(message = "La contraseña no puede estar vacía")
    private String contraseña;

    @NotNull(message = "El indicador de gestor no puede ser nulo")
    private Boolean gestor;

    @ManyToOne
    @JoinColumn(name = "comunidad")
    private Comunidad comunidad;

    @OneToMany(mappedBy = "vecino")
    private List<Reserva> reserva;

    @OneToMany(mappedBy = "vecino")
    private List<Informacion> informacions;

    public Vecino() {
    }

    public Long getIdvecino() {
        return idvecino;
    }

    public void setIdvecino(Long idvecino) {
        this.idvecino = idvecino;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombredeusuario() {
        return nombredeusuario;
    }

    public void setNombredeusuario(String nombredeusuario) {
        this.nombredeusuario = nombredeusuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Boolean getGestor() {
        return gestor;
    }

    public void setGestor(Boolean gestor) {
        this.gestor = gestor;
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
