package io.grupo14.tucomunidad14.model;


import java.time.LocalDateTime;

public class ReservaSimpleDTO {
    private Long idreserva;
    private Long idvecino;
    private Long idarea;
    // Campo para el inicio de la reserva
    private LocalDateTime inicioReserva;

    // Campo para el fin de la reserva
    private LocalDateTime finReserva;
    
    
    
    public ReservaSimpleDTO() {
    }
    public LocalDateTime getInicioReserva() {
        return inicioReserva;
    }
    public void setInicioReserva(LocalDateTime inicioReserva) {
        this.inicioReserva = inicioReserva;
    }
    public LocalDateTime getFinReserva() {
        return finReserva;
    }
    public void setFinReserva(LocalDateTime finReserva) {
        this.finReserva = finReserva;
    }
    public Long getIdreserva() {
        return idreserva;
    }
    public void setIdreserva(Long idreserva) {
        this.idreserva = idreserva;
    }
    public Long getIdvecino() {
        return idvecino;
    }
    public void setIdvecino(Long idvecino) {
        this.idvecino = idvecino;
    }
    public Long getIdarea() {
        return idarea;
    }
    public void setIdarea(Long idarea) {
        this.idarea = idarea;
    }
    
    

    
}