package io.grupo14.tucomunidad14.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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

    @Autowired
    private JavaMailSender mailSender;
  
    @PostMapping("/crearcomunidad")
    @ResponseBody
    public Long crearComunidad(@RequestBody ComunidadDTO comunidadDTO) {
        Comunidad nuevaComunidad = new Comunidad();
        nuevaComunidad.setNombre(comunidadDTO.getNombre());
        nuevaComunidad.setCodpostal(comunidadDTO.getCodpostal());
        comunidadRepository.save(nuevaComunidad);
        String email = comunidadDTO.getEmail();

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

}
