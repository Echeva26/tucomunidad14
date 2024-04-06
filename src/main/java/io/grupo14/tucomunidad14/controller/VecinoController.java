package io.grupo14.tucomunidad14.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.grupo14.tucomunidad14.model.Vecino;

import io.grupo14.tucomunidad14.repository.VecinoRepository;
import org.slf4j.Logger;
public class VecinoController {


   
    @Autowired
    private VecinoRepository vecinoRepository;
    
    public static final Logger log = LoggerFactory.getLogger(ReservasController.class);

    

    
    @PostMapping("/vecinos")
    public Vecino createVecino(@RequestBody Vecino vecino) {
        return vecinoRepository.save(vecino);
    }
    
    

}
