package io.grupo14.tucomunidad14.controller;

import org.springframework.web.bind.annotation.RestController;

import io.grupo14.tucomunidad14.model.Areacomun;
import io.grupo14.tucomunidad14.model.AreacomunDTO;
import io.grupo14.tucomunidad14.model.Comunidad;
import io.grupo14.tucomunidad14.model.Tipodearea;
import io.grupo14.tucomunidad14.repository.AreacomunRepository;
import io.grupo14.tucomunidad14.repository.ComunidadRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;


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

    @GetMapping("/tipodeareaporcomunidad")
    public List<Tipodearea> getMethodName(@RequestParam Long idcomunidad) {
        List <Tipodearea> areas  = areacomunRepository.getListadeAreas(idcomunidad);
        
        return areas;
        
    }
    
}