package io.grupo14.tucomunidad14.model;

import java.sql.Date;

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
    @JoinColumn(name = "vecino_id")
    private Vecino vecino;
    @ManyToOne
    @JoinColumn(name = "area_id")
    private Areacomun areacomun;
    private Date horareserva;
    
    
    
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
    public Date getHorareserva() {
        return horareserva;
    }
    public void setHorareserva(Date horareserva) {
        this.horareserva = horareserva;
    }

    

    
}
