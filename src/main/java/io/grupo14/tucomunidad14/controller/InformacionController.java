package io.grupo14.tucomunidad14.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import io.grupo14.tucomunidad14.repository.AreacomunRepository;
import io.grupo14.tucomunidad14.repository.ComunidadRepository;

@RestController
public class InformacionController {

    @Autowired
    private ComunidadRepository comunidadRepository;

    @Autowired
    private AreacomunRepository areacomunRepository;

    public InformacionController() {
    }

    public ComunidadRepository getComunidadRepository() {
        return comunidadRepository;
    }

    public void setComunidadRepository(ComunidadRepository comunidadRepository) {
        this.comunidadRepository = comunidadRepository;
    }

    public AreacomunRepository getAreacomunRepository() {
        return areacomunRepository;
    }

    public void setAreacomunRepository(AreacomunRepository areacomunRepository) {
        this.areacomunRepository = areacomunRepository;
    }

    
    
}
