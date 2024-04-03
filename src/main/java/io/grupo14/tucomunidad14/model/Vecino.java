package io.grupo14.tucomunidad14.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;

@Entity
@Table(name= "users")
public class Vecino {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String Apellidos;
    private @Email String email;
    private Integer portal;
    private Integer piso;
    private Integer telefono;


    public Long getId() {
        return id;
    }
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidos() {
        return Apellidos;
    }
    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }
    public String getEmail() {
        return email;
    }
    public void setTutor(String email) {
        this.email = email;
    }
    public Integer getPortal() {
        return portal;
    }
    public void setPortal(Integer portal) {
        this.portal = portal;
    }
    public Integer getPiso() {
        return piso;
    }
    public void setPiso(Integer piso) {
        this.piso = piso;
    }
    public Integer getTelefono() {
        return telefono;
    }
    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }
    
    


}
