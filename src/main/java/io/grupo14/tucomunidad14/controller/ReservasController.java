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
import org.springframework.web.bind.annotation.GetMapping;
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
        // Paso 1: Buscar las entidades relacionadas basadas en el DTO
        Areacomun areaComun = areaComunRepository.findById(reservaDTO.getIdarea()).orElseThrow(() -> new RuntimeException("Área común no encontrada"));
        Vecino vecino = vecinoRepository.findById(reservaDTO.getIdvecino()).orElseThrow(() -> new RuntimeException("Vecino no encontrado"));

        // Aquí ya tenemos el área común, que incluye el tipo de área como un parámetro enumerable

        // Paso 2: Crear la entidad Reserva con los datos y relaciones
        Reserva nuevaReserva = new Reserva();
        nuevaReserva.setAreacomun(areaComun);
        nuevaReserva.setVecino(vecino);
        nuevaReserva.setInicioReserva(reservaDTO.getInicioReserva());
        nuevaReserva.setFinReserva(reservaDTO.getFinReserva());
        // Establecer cualquier otro campo necesario de Reserva desde reservaDTO

        // Paso 3: Guardar la reserva en la base de datos
        Reserva reservaGuardada = reservasRepository.save(nuevaReserva);

        // Paso 4: Devolver la reserva guardada y un estado HTTP adecuado
        return ResponseEntity.ok(reservaGuardada);
    }

    //Acuerdate que tienes que sacar por tipo para las pantallas 
}
    

    


