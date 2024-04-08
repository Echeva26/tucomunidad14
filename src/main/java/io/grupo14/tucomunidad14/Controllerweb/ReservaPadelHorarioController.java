package io.grupo14.tucomunidad14.Controllerweb;

/*import io.grupo14.tucomunidad14.model.ReservaSimpleDTO;
import io.grupo14.tucomunidad14.repository.ReservasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ReservaPadelHorarioController {

    private final ReservasRepository reservasRepository;

    @Autowired
    public ReservaPadelHorarioController(ReservasRepository reservasRepository) {
        this.reservasRepository = reservasRepository;
    }

    @GetMapping("/reservas/horario-padel/{areaComunId}")
    public List<ReservaSimpleDTO> obtenerReservasPorAreaComunYDia(
            @PathVariable Long areaComunId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {

        LocalDateTime inicioDelDia = fecha.atStartOfDay(); // 00:00 del día
        LocalDateTime finDelDia = fecha.atTime(23, 59, 59); // Fin del día

        Timestamp inicio = Timestamp.valueOf(inicioDelDia);
        Timestamp fin = Timestamp.valueOf(finDelDia);

        List<ReservaSimpleDTO> reservas = reservasRepository.findReservasByAreaComunIdAndDay(areaComunId, inicio, fin);

        // Aquí podrías agregar lógica adicional si es necesario antes de devolver las reservas
        return reservas;
    }
}
*/
