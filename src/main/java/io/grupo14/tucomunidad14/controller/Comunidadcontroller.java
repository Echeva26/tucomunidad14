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
public class ComunidadController {
    @Autowired
    private ComunidadRepository comunidadRepository;

    @PostMapping("/comunidad/unirse")
    @ResponseBody
    public String agregarVecinoAComunidad(@PathVariable Long comunidadId, @RequestBody Vecino nuevoVecino) {
        Comunidad comunidad = comunidadRepository.findById(comunidadId).orElse(null);
        if (comunidad != null) {
            comunidad.getVecinos().add(nuevoVecino);
            nuevoVecino.setComunidad(comunidad); // Asignamos la comunidad al vecino
            comunidadRepository.save(comunidad);
            return "Vecino añadido exitosamente a la comunidad con ID " + comunidadId;
        } else {
            return "No se encontró la comunidad con ID " + comunidadId;
        }
    }

}