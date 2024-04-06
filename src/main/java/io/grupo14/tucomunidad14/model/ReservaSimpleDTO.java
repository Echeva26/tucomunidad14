package io.grupo14.tucomunidad14.model;


import java.sql.Timestamp;

public class ReservaSimpleDTO {
    private Long idreserva;
    private Long idvecino;
    private Long idarea;
    private Timestamp horareserva;

    
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
    public Timestamp getHorareserva() {
        return horareserva;
    }
    public void setHorareserva(Timestamp horareserva) {
        this.horareserva = horareserva;
    }
    

    
}