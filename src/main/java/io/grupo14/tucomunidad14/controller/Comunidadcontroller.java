package io.grupo14.tucomunidad14.controller;

import org.springframework.web.bind.annotation.RestController;

import io.grupo14.tucomunidad14.model.Comunidad;
import io.grupo14.tucomunidad14.model.ComunidadDTO;
import io.grupo14.tucomunidad14.repository.ComunidadRepository;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class Comunidadcontroller {
    @Autowired
    private ComunidadRepository comunidadRepository;

//Cuando hago un post para crear una comunidad
    @PostMapping("/crearcomunidad")
    @ResponseBody
    public String crearComunidad(@RequestBody ComunidadDTO comunidadDTO) {
        Comunidad nuevaComunidad = new Comunidad();
        nuevaComunidad.setNombre(comunidadDTO.getNombre());
        nuevaComunidad.setCodpostal(comunidadDTO.getCodpostal());
        comunidadRepository.save(nuevaComunidad); 
        return "Comunidad creada exitosamente";
    }

}