package io.grupo14.tucomunidad14.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import io.grupo14.tucomunidad14.model.Comunidad;
import io.grupo14.tucomunidad14.model.ComunidadDTO;

import io.grupo14.tucomunidad14.repository.ComunidadRepository;

@RestController
public class Comunidadcontroller {
    

    @Autowired
    private ComunidadRepository comunidadRepository;

  
    @PostMapping("/crearcomunidad")
    @ResponseBody
    public Long crearComunidad(@RequestBody ComunidadDTO comunidadDTO) {
        Comunidad nuevaComunidad = new Comunidad();
        nuevaComunidad.setNombre(comunidadDTO.getNombre());
        nuevaComunidad.setCodpostal(comunidadDTO.getCodpostal());
        comunidadRepository.save(nuevaComunidad);

    
        return nuevaComunidad.getIdcomunidad();
    }

}
