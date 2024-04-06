package io.grupo14.tucomunidad14.controller;

import org.springframework.web.bind.annotation.RestController;

import io.grupo14.tucomunidad14.model.Areacomun;
import io.grupo14.tucomunidad14.model.Tipodearea;
import io.grupo14.tucomunidad14.repository.AreacomunRepository;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

//hola
@RestController
public class Areacontroller {
    @Autowired
    private AreacomunRepository areacomunRepository;
    @PostMapping("/creararea")
    public String CrearArea (@RequestParam String nombre, @RequestParam Tipodearea tipodearea, @RequestParam Long idComunidad){
        Areacomun nuevaArea = new Areacomun();
        nuevaArea.setNombre(nombre);
        nuevaArea.setTipodearea(tipodearea);
        areacomunRepository.save(nuevaArea);
        return "Area creada exitosamente";
    }

}