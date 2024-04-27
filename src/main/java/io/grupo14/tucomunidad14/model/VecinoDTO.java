package io.grupo14.tucomunidad14.model;

public class VecinoDTO {

    private Long idvecino; // Usado para actualización, puede ser null para creación
    private String nombre;
    private String apellidos;
    private String email;
    private String nombredeusuario;
    private String contraseña;
    private Boolean gestor;
    private Long idComunidad; // Este es el ID de la comunidad asociada

    // Constructor sin argumentos
    public VecinoDTO() {
    }

    // Getters y setters
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

    public Long getIdComunidad() {
        return idComunidad;
    }

    public void setIdComunidad(Long idComunidad) {
        this.idComunidad = idComunidad;
    }

}
