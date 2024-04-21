package io.grupo14.tucomunidad14.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.grupo14.tucomunidad14.model.Areacomun;
import io.grupo14.tucomunidad14.model.Comunidad;
import io.grupo14.tucomunidad14.model.ComunidadDTO;
import io.grupo14.tucomunidad14.model.Tipodearea;
import io.grupo14.tucomunidad14.repository.AreacomunRepository;
import io.grupo14.tucomunidad14.repository.ComunidadRepository;

@RestController
public class Comunidadcontroller {
   

    @Autowired
    private ComunidadRepository comunidadRepository;

    @Autowired
    private AreacomunRepository areacomunRepository;
    @PostMapping("/crearcomunidad")
    @ResponseBody
    public String crearComunidad(@RequestBody ComunidadDTO comunidadDTO) {
        return "hola";
    }

}
