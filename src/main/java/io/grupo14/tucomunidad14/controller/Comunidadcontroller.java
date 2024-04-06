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

//Cuando hago un post para unirme a una comunidad 
    @PostMapping("/comunidad/unirse")
    @ResponseBody
    public String agregarVecinoAComunidad(@PathVariable Long comunidadId, @RequestBody Vecino nuevoVecino) {
        Comunidad comunidad = comunidadRepository.findById(comunidadId).orElse(null);
        if (comunidad != null) {
            comunidad.getVecinos().add(nuevoVecino);
            nuevoVecino.setComunidad(comunidad); // Asignamos la comunidad al vecino
            comunidadRepository.save(comunidad);
            return "Vecino añadido exitosamente a la comunidad con ID " + comunidadId;
        } else {
            return "No se encontró la comunidad con ID " + comunidadId;
        }
    }
    



}