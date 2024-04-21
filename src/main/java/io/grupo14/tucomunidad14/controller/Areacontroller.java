package io.grupo14.tucomunidad14.controller;

import org.springframework.web.bind.annotation.RestController;

import io.grupo14.tucomunidad14.model.Areacomun;
import io.grupo14.tucomunidad14.model.AreacomunDTO;
import io.grupo14.tucomunidad14.model.Comunidad;
import io.grupo14.tucomunidad14.model.Tipodearea;
import io.grupo14.tucomunidad14.repository.AreacomunRepository;
import io.grupo14.tucomunidad14.repository.ComunidadRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//hola
@RestController
public class Areacontroller {

    @Autowired
    private ComunidadRepository comunidadRepository;

    @Autowired
    private AreacomunRepository areacomunRepository;

    @PostMapping("/creararea")
    public ResponseEntity<Map<String, String>> crearArea(@RequestBody AreacomunDTO areacomunDTO) {
        Map<String, String> response = new HashMap<>();
        try {
            Comunidad comunidad = comunidadRepository.findById(areacomunDTO.getIdComunidad())
                    .orElseThrow(() -> new RuntimeException(
                            "Comunidad no encontrada con id: " + areacomunDTO.getIdComunidad()));

            // Convertir la cadena seleccionada en el selector al tipo de área del enumerado
            Tipodearea tipoDeArea = Tipodearea.valueOf(areacomunDTO.getTipodearea().toUpperCase());

            Areacomun nuevaArea = new Areacomun();
            nuevaArea.setNombre(areacomunDTO.getNombre());
            nuevaArea.setTipodearea(tipoDeArea); // Asignar el tipo de área del enumerado
            nuevaArea.setComunidad(comunidad);
            areacomunRepository.save(nuevaArea);

            response.put("message", "Se ha creado correctamente el área común");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            response.put("error", "Error al crear el área común: " + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping("/tipodeareaporcomunidad")
    public List<Tipodearea> getMethodName(@RequestParam Long idcomunidad) {
        List<Tipodearea> areas = areacomunRepository.getListadeAreas(idcomunidad);

        return areas;

    }

}