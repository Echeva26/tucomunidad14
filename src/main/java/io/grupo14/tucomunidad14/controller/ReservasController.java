package io.grupo14.tucomunidad14.controller;

import org.springframework.web.bind.annotation.RestController;

import io.grupo14.tucomunidad14.model.Areacomun;
import io.grupo14.tucomunidad14.model.Reserva;
import io.grupo14.tucomunidad14.model.ReservaSimpleDTO;
import io.grupo14.tucomunidad14.model.Vecino;
import io.grupo14.tucomunidad14.repository.AreacomunRepository;
import io.grupo14.tucomunidad14.repository.ReservasRepository;
import io.grupo14.tucomunidad14.repository.VecinoRepository;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api")
public class ReservasController {
    @Autowired
    private final ReservasRepository reservasRepository;


    // Suponiendo la existencia de servicios o repositorios para estas entidades
    
    @Autowired
    private AreacomunRepository areaComunRepository;
    @Autowired
    private VecinoRepository vecinoRepository;
    
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
            dto.setInicioReserva(reserva.getInicioReserva());;
            dto.setFinReserva(reserva.getFinReserva());
            return dto;
        }).collect(Collectors.toList());
    }

    @PostMapping("/reservas")
    public ResponseEntity<Reserva> crearReserva(@RequestBody ReservaSimpleDTO reservaDTO) {
        
        Areacomun areaComun = areaComunRepository.findById(reservaDTO.getIdarea()).orElseThrow(() -> new RuntimeException("Área común no encontrada"));
        Vecino vecino = vecinoRepository.findById(reservaDTO.getIdvecino()).orElseThrow(() -> new RuntimeException("Vecino no encontrado"));

        
        Reserva nuevaReserva = new Reserva();
        nuevaReserva.setAreacomun(areaComun);
        nuevaReserva.setVecino(vecino);
        nuevaReserva.setInicioReserva(reservaDTO.getInicioReserva());
        nuevaReserva.setFinReserva(reservaDTO.getFinReserva());
       
        Reserva reservaGuardada = reservasRepository.save(nuevaReserva);

        
        return ResponseEntity.ok(reservaGuardada);
    }

    @DeleteMapping("/reservas/{id}")
    public ResponseEntity<Reserva> eliminarReserva(@PathVariable Long id) {
        if (!reservasRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        reservasRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/reservas/eliminarPorVecino/{vecinoId}")
    public String eliminarReservasPorVecino(@PathVariable Long vecinoId) {
        // Primero, verifica si el vecino existe
        if (!vecinoRepository.existsById(vecinoId)) {
            return "El vecino con ID " + vecinoId + " no existe.";
        }
        
        // Encuentra y elimina las reservas asociadas al vecino
        List<Reserva> reservas = reservasRepository.findByVecinoId(vecinoId);
        if (reservas.isEmpty()) {
            return "No se encontraron reservas para el vecino con ID " + vecinoId;
        }

        reservasRepository.deleteAll(reservas);
        return "Reservas eliminadas correctamente para el vecino con ID " + vecinoId;
    }

    @GetMapping("/reservas/porAreaComun/{areaComunId}")
    public List<Reserva> obtenerReservasPorAreaComun(@PathVariable Long areaComunId) {
        return reservasRepository.findByAreacomunId(areaComunId);
    }

    
}
    

    


