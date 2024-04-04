package io.grupo14.tucomunidad14.controller;

import org.springframework.web.bind.annotation.RestController;


import io.grupo14.tucomunidad14.model.Reserva;
import io.grupo14.tucomunidad14.repository.ReservasRepository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ReservasController {

    private final ReservasRepository reservasRepository;

    public static final Logger log = LoggerFactory.getLogger(ReservasController.class);
    
    public ReservasController(ReservasRepository reservasRepository) {
        this.reservasRepository = reservasRepository;
    }

    @GetMapping("/reservas")
    List<Reserva> readAll() {

        return (List<Reserva>) reservasRepository.findAll();
  
    }

    @GetMapping("/reservas/pistaspadel/{comunidad}")
    public String getPistasdePadel(@RequestParam String id) {
        return new String();
    }

    @GetMapping("/reservas/local/{comunidad}")
    public String getMethodName(@RequestParam String param) {
        return new String();
    }

}
