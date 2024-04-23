package io.grupo14.tucomunidad14.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import io.grupo14.tucomunidad14.model.Comunidad;
import io.grupo14.tucomunidad14.model.ComunidadDTO;

import io.grupo14.tucomunidad14.repository.ComunidadRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class Comunidadcontroller {
    

    @Autowired
    private ComunidadRepository comunidadRepository;

    @Autowired
    private JavaMailSender mailSender;
  
    @PostMapping("/crearcomunidad")
    @ResponseBody
    public Long crearComunidad(@RequestBody ComunidadDTO comunidadDTO) {
        Comunidad nuevaComunidad = new Comunidad();
        nuevaComunidad.setNombre(comunidadDTO.getNombre());
        nuevaComunidad.setCodpostal(comunidadDTO.getCodpostal());
        comunidadRepository.save(nuevaComunidad);
        // String email = comunidadDTO.getEmail();
        String email = "jeu2604@gmail.com";
        enviarEmail(nuevaComunidad.getIdcomunidad(),email);

    
        return nuevaComunidad.getIdcomunidad();
    }
    private void enviarEmail(Long idComunidad,String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("tucomunidad14.app@gmail.com");
        message.setTo(email);
        message.setSubject("Nueva Comunidad Creada");
        message.setText("Se ha creado una nueva comunidad con ID: " + idComunidad);
        mailSender.send(message);
    }

    @GetMapping("/comunidadbyid")
    public ResponseEntity<?> comunidadbyid(@RequestParam Long idcomunidad) {
        Optional<Comunidad> comunidad = comunidadRepository.findById(idcomunidad);
        if (comunidad.isPresent()) {
            ComunidadDTO comunidadDTO = new ComunidadDTO();
            comunidadDTO.setNombre(comunidad.get().getNombre());
            comunidadDTO.setCodpostal(comunidad.get().getCodpostal());
            comunidadDTO.setIdcomunidad(comunidad.get().getIdcomunidad());
            return ResponseEntity.ok(comunidadDTO);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No consta esa comunidad");
        }
    }
    

}
