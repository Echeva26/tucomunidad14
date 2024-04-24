package io.grupo14.tucomunidad14.controller;

import org.springframework.web.bind.annotation.RestController;

import io.grupo14.tucomunidad14.model.Areacomun;
import io.grupo14.tucomunidad14.model.AreacomunDTO;
import io.grupo14.tucomunidad14.model.Comunidad;
import io.grupo14.tucomunidad14.model.Tipodearea;

import io.grupo14.tucomunidad14.repository.AreacomunRepository;
import io.grupo14.tucomunidad14.repository.ComunidadRepository;

import java.util.List;
import java.util.Map;

import java.util.stream.Collectors;

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
    private AreacomunRepository areacomunRepository;

    @Autowired
    private ComunidadRepository comunidadRepository;

    @PostMapping("/creararea")
    public ResponseEntity<?> crearArea(@RequestBody AreacomunDTO areacomunDTO) {
        Comunidad comunidad = comunidadRepository.findById(areacomunDTO.getIdComunidad()).orElseThrow(
                () -> new RuntimeException("Comunidad no encontrada con id: " + areacomunDTO.getIdComunidad()));

        Areacomun nuevaArea = new Areacomun();
        nuevaArea.setNombre(areacomunDTO.getNombre());
        // Convertir el valor entero a enum y obtener la descripción
        nuevaArea.setTipodearea(Tipodearea.fromValue(areacomunDTO.getTipodearea()));
        nuevaArea.setComunidad(comunidad); // Asignar la comunidad encontrada
        areacomunRepository.save(nuevaArea);
        return ResponseEntity.ok().body(Map.of("message", "Se ha creado correctamente el área"));
    }

    @GetMapping("/tipodeareaporcomunidad")
    public List<Tipodearea> getMethodName(@RequestParam Long idcomunidad) {
        List<Tipodearea> areas = areacomunRepository.getListadeAreas(idcomunidad);

        return areas;

    }

    @GetMapping("/areasporvecino")
    public ResponseEntity<List<AreacomunDTO>> areasPorVecino(@RequestParam Long idvecino) {
        Comunidad comunidad = comunidadRepository.findByVecinosContainsId(idvecino);
        if (comunidad == null) {
            return ResponseEntity.notFound().build();
        }
        List<Areacomun> areas = areacomunRepository.getAreacomunsbycomunidad(comunidad.getIdcomunidad());
        List<AreacomunDTO> areasDto = areas.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(areasDto);
    }

    private AreacomunDTO convertToDto(Areacomun area) {
        AreacomunDTO dto = new AreacomunDTO();
        dto.setIdarea(area.getIdarea());
        dto.setNombre(area.getNombre());
        dto.setTipodearea(area.getTipodearea().getValue());
        dto.setIdComunidad(area.getComunidad().getIdcomunidad());
        // set otros campos necesarios
        return dto;
    }

    @GetMapping("/areasporvecinoytipo")
    public ResponseEntity<List<AreacomunDTO>> areasPorVecinoytipo(@RequestParam Long idvecino,
            @RequestParam Integer tipodearea) {

        Comunidad comunidad = comunidadRepository.findByVecinosContainsId(idvecino);
        if (comunidad == null) {
            return ResponseEntity.notFound().build();
        }

        List<Areacomun> areas = areacomunRepository.getAreacomunsbycomunidadandtype(idvecino,
                Tipodearea.fromValue(tipodearea));
        List<AreacomunDTO> areasDto = areas.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(areasDto);

    }

}