package io.grupo14.tucomunidad14.controller;

public class CambioContrasenaRequest {
    private String nombredeusuario;
    private String contraseña; // Nueva contraseña

    
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

    
}

