package io.grupo14.tucomunidad14.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "RESERVA")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idreserva;

    @NotNull(message = "El vecino no puede ser nulo")
    @ManyToOne
    @JoinColumn(name = "vecino")
    private Vecino vecino;

    @NotNull(message = "El área común no puede ser nulo")
    @ManyToOne
    @JoinColumn(name = "area")
    private Areacomun areacomun;

    @NotNull(message = "La fecha y hora de inicio de reserva no pueden ser nulas")
    private LocalDateTime inicioReserva;

    @NotNull(message = "La fecha y hora de fin de reserva no pueden ser nulas")
    private LocalDateTime finReserva;

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
}
