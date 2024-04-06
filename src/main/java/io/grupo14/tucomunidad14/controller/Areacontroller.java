package io.grupo14.tucomunidad14.controller;

import org.springframework.web.bind.annotation.RestController;

import io.grupo14.tucomunidad14.model.Areacomun;
import io.grupo14.tucomunidad14.model.AreacomunDTO;
import io.grupo14.tucomunidad14.model.Comunidad;
import io.grupo14.tucomunidad14.repository.AreacomunRepository;
import io.grupo14.tucomunidad14.repository.ComunidadRepository;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


//hola
@RestController
public class Areacontroller {
    @Autowired
    private AreacomunRepository areacomunRepository;

    @Autowired 
    private ComunidadRepository comunidadRepository;
    @PostMapping("/creararea")


    public String crearArea(@RequestBody AreacomunDTO areacomunDTO) {
    Comunidad comunidad = comunidadRepository.findById(areacomunDTO.getIdComunidad()).orElseThrow(
        () -> new RuntimeException("Comunidad no encontrada con id: " + areacomunDTO.getIdComunidad())
    );

    Areacomun nuevaArea = new Areacomun();
    nuevaArea.setNombre(areacomunDTO.getNombre());
    nuevaArea.setTipodearea(areacomunDTO.getTipodearea());
    nuevaArea.setComunidad(comunidad); // Asignar la comunidad encontrada
    areacomunRepository.save(nuevaArea);
    return "Se ha creado correctamente el area";
}
}