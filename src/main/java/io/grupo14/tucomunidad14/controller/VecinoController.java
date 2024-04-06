package io.grupo14.tucomunidad14.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import io.grupo14.tucomunidad14.repository.AreacomunRepository;
import io.grupo14.tucomunidad14.repository.ReservasRepository;
import io.grupo14.tucomunidad14.repository.VecinoRepository;
import org.slf4j.Logger;
public class VecinoController {


    @Autowired
    private final ReservasRepository reservasRepository;


    // Suponiendo la existencia de servicios o repositorios para estas entidades
    
    @Autowired
    private AreacomunRepository areaComunRepository;
    @Autowired
    private VecinoRepository vecinoRepository;
    
    public static final Logger log = LoggerFactory.getLogger(ReservasController.class);

    public VecinoController(ReservasRepository reservasRepository, AreacomunRepository areaComunRepository,
            VecinoRepository vecinoRepository) {
        this.reservasRepository = reservasRepository;
        this.areaComunRepository = areaComunRepository;
        this.vecinoRepository = vecinoRepository;
    }
    

    
    
    

}
