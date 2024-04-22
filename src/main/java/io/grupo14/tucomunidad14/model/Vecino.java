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
import java.util.List;


@Entity
@Table(name= "VECINO")
public class Vecino {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idvecino;
    private String nombre;
    private String apellidos;
    private @Email String email;
    private String nombredeusuario;
    private String contraseña;
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

    
    
    public Long getIdvecino() {
        return idvecino;
    }

    public void setIdvecino(Long idvecino) {
        this.idvecino = idvecino;
    }

    public List<Reserva> getReserva() {
        return reserva;
    }

    public void setReserva(List<Reserva> reserva) {
        this.reserva = reserva;
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
    
}
