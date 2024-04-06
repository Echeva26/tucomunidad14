package io.grupo14.tucomunidad14.model;



import java.sql.Timestamp;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@EntityScan
@Table(name= "RESERVA")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idreserva;
    @ManyToOne
    @JoinColumn(name = "vecino")
    private Vecino vecino;
    @ManyToOne
    @JoinColumn(name = "area")
    private Areacomun areacomun;
    // Campo para el inicio de la reserva
    private Timestamp inicioReserva;

    // Campo para el fin de la reserva
    private Timestamp finReserva;
    
    
    
    public Timestamp getInicioReserva() {
        return inicioReserva;
    }
    public void setInicioReserva(Timestamp inicioReserva) {
        this.inicioReserva = inicioReserva;
    }
    public Timestamp getFinReserva() {
        return finReserva;
    }
    public void setFinReserva(Timestamp finReserva) {
        this.finReserva = finReserva;
    }
    public Reserva() {
    }
    public Long getIdreserva() {
        return idreserva;
    }
    public void setIdreserva(Long idreserva) {
        this.idreserva = idreserva;
    }
    public Vecino getVecino() {
        return vecino;
    }
    public void setVecino(Vecino vecino) {
        this.vecino = vecino;
    }
    public Areacomun getAreacomun() {
        return areacomun;
    }
    public void setAreacomun(Areacomun areacomun) {
        this.areacomun = areacomun;
    }
    

    

    
}
