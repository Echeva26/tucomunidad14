package io.grupo14.tucomunidad14.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import io.grupo14.tucomunidad14.model.Comunidad;
import io.grupo14.tucomunidad14.model.ComunidadDTO;

import io.grupo14.tucomunidad14.repository.ComunidadRepository;

@RestController
public class Comunidadcontroller {

    @Autowired
    private ComunidadRepository comunidadRepository;

    @PostMapping("/crearcomunidad")
    public ResponseEntity<Map<String, Object>> crearComunidad(@RequestBody ComunidadDTO comunidadDTO) {
        try {
            Comunidad nuevaComunidad = new Comunidad();
            nuevaComunidad.setNombre(comunidadDTO.getNombre());
            nuevaComunidad.setCodpostal(comunidadDTO.getCodpostal());
            comunidadRepository.save(nuevaComunidad);

            Map<String, Object> response = new HashMap<>();
            response.put("id", nuevaComunidad.getIdcomunidad()); // Agregar el ID de la comunidad a la respuesta
            response.put("message", "Se ha creado correctamente la comunidad");
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Error al crear la comunidad: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

}
