package io.grupo14.tucomunidad14.controller;

import org.springframework.web.bind.annotation.RestController;

import io.grupo14.tucomunidad14.model.Comunidad;


import io.grupo14.tucomunidad14.repository.ComunidadRepository;






import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class Comunidadcontroller {
    @Autowired
    private ComunidadRepository comunidadRepository;

//Cuando hago un post para crear una comunidad
   @PostMapping("/crear")
   @ResponseBody
    public String crearComunidad(@RequestParam String nombre, @RequestParam Integer codpostal) {
        Comunidad nuevaComunidad = new Comunidad();
        nuevaComunidad.setNombre(nombre);
        nuevaComunidad.setCodpostal(codpostal);
         // Lista de áreas comunes inicialmente vacía

        comunidadRepository.save(nuevaComunidad);

        return "Comunidad creada exitosamente";
    }





}