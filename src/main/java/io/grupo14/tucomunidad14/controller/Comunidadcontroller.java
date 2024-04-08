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
    private static final Tipodearea LOCAL = null;

    @Autowired
    private ComunidadRepository comunidadRepository;

    @Autowired
    private AreacomunRepository areacomunRepository;
    @PostMapping("/crearcomunidad")
    @ResponseBody
    public String crearComunidad(@RequestBody ComunidadDTO comunidadDTO) {
        Comunidad nuevaComunidad = new Comunidad();
        nuevaComunidad.setNombre(comunidadDTO.getNombre());
        nuevaComunidad.setCodpostal(comunidadDTO.getCodpostal());
        comunidadRepository.save(nuevaComunidad);

        Areacomun areacomun = new Areacomun();
        Tipodearea Local = LOCAL;
        areacomun.setTipodearea(Local);
        areacomun.setNombre("Local");
        areacomun.setComunidad(nuevaComunidad);
        areacomunRepository.save(areacomun);


        return "Comunidad creada exitosamente";
    }

}
