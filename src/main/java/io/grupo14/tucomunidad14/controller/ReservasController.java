package io.grupo14.tucomunidad14.controller;

import org.springframework.web.bind.annotation.RestController;


import io.grupo14.tucomunidad14.model.Reserva;
import io.grupo14.tucomunidad14.model.ReservaSimpleDTO;
import io.grupo14.tucomunidad14.repository.ReservasRepository;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ReservasController {
    @Autowired
    private final ReservasRepository reservasRepository;
    
    public static final Logger log = LoggerFactory.getLogger(ReservasController.class);
    
    

    public ReservasController(ReservasRepository reservasRepository) {
        this.reservasRepository = reservasRepository;
        
    }

    @GetMapping("/reservas/comunidad")
public ResponseEntity<List<ReservaSimpleDTO>> obtenerReservasPorComunidad(@RequestParam Long idcomunidad) {
    List<ReservaSimpleDTO> reservas = obtenerReservasSimplificadas(idcomunidad);
    return ResponseEntity.ok(reservas);
}

    public List<ReservaSimpleDTO> obtenerReservasSimplificadas(Long idComunidad) {
        // Suponiendo que tienes un método que te devuelve las reservas por comunidad
        List<Reserva> reservas = reservasRepository.buscarPorComunidadId(idComunidad);
        return reservas.stream().map(reserva -> {
            ReservaSimpleDTO dto = new ReservaSimpleDTO();
            dto.setIdreserva(reserva.getIdreserva());
            dto.setIdvecino(reserva.getVecino().getIdvecino());
            dto.setIdarea(reserva.getAreacomun().getIdarea());
            dto.setHorareserva(reserva.getHorareserva());
            return dto;
        }).collect(Collectors.toList());
    }
    

}
